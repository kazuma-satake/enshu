package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserLoginRepositoryImpl implements UserLoginRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public Boolean findByActiveTrue(String userId, String passNumber) {
		
		String sql =
				"SELEC EXISTS (									" +
						"SELECT 1								" +
						"FROM									" +
						"	user_accounts ua					" +
						"WHERE									" +
						"	ua.User_id = ?	AND ua.Password = ?	" +
				")";
		
		Boolean result = jdbcTemplate.queryForObject(sql,Boolean.class, userId, passNumber);
		
		
		
		
		return result;
	}
}
