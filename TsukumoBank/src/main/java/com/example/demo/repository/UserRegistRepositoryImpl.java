package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewUser;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRegistRepositoryImpl implements UserRegistRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public Boolean userIdCheack(String userId) {
		String sql =
				"SELECT EXISTS (									" +
						"SELECT 1								" +
						"FROM									" +
						"	user_info ui					" +
						"WHERE									" +
						"	ui.User_id = ?" +
				")";
		Boolean result = jdbcTemplate.queryForObject(sql,Boolean.class, userId);
		
		return result;
	}
	
	public void add(NewUser newUser) {
//		System.out.println("登録しました。");
//		System.out.println(newUser);
		
		HashedString hs = new HashedString();
		String hashedpassNumber = hs.hashe_sha256(newUser.getPassNumber());
		
		String sql_createUserInfo = "insert into User_info" +
				"(User_id, User_name, User_number, User_address, Password)" +
				"values(?,?,?,?,?)";
		
		String sql_createUserBalanceInfo = "insert into balance_info(User_id, Balance) values(?,?)";
		
		
		String tableName = newUser.getUserId();
		String sql_createHistoryTable = 
				"CREATE TABLE " + tableName + " ("
				+ "id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "Date timestamp not null, "
				+ "Type varchar(32) not null, "
				+ "Amount integer not null, "
				+ "Balance bigint not null,"
				+ "Remarks varchar(255))";
		
		jdbcTemplate.update(sql_createUserInfo, newUser.getUserId(),
								 newUser.getUserName(),
								 newUser.getPhoneNumber(),
								 newUser.getAddress(),
								 hashedpassNumber
								 );
		
		jdbcTemplate.update(sql_createUserBalanceInfo, newUser.getUserId(), 0);
		
		jdbcTemplate.execute(sql_createHistoryTable);
		
		System.out.println("登録しました。");
	}
}