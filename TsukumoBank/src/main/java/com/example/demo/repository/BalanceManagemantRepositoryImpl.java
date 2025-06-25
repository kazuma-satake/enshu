package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Balance;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BalanceManagemantRepositoryImpl implements BalanceManagementRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public Balance getValue(Balance balance) {
		String sql =
				"SELECT Balance								" +
				"FROM									" +
				"	balance_info				" +
				"WHERE									" +
				"	User_id = ?" ;
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, balance.getUserId());
		
		if (result >= 0) {
            balance.setValueBalance(result);
        } else {
            
        }
		
		return balance;
	}
}
