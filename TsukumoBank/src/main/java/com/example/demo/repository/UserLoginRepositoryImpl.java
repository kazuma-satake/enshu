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
		
		HashedString hs = new HashedString();
		String hashed_passNumber = hs.hashe_sha256(passNumber);
		
		String sql =
				"SELECT EXISTS (									" +
						"SELECT 1								" +
						"FROM									" +
						"	user_info ui					" +
						"WHERE									" +
						"	ui.User_id = ?	AND ui.Password = ?	" +
				")";
		
		Boolean result = jdbcTemplate.queryForObject(sql,Boolean.class, userId, hashed_passNumber);
		
		return result;
	}
}
