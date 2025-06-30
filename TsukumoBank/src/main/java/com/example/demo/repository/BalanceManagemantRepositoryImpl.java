package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Balance;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BalanceManagemantRepositoryImpl implements BalanceManagementRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	/***************************/
	/***** 入出金共通SQL文 *****/
	/***************************/
	private final String sql_update = 
			"UPDATE balance_info							" +
			"SET									" +
			"	balance = ?				" +
			"WHERE									" +
			"	User_id = ?" ;
	
	public Balance getBalance(Balance balance) {
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
	
	public Balance deposit(Balance balance) {
		int valueBalance = balance.getValueBalance();
		int amount = balance.getAmount();
		
		int target = valueBalance + amount;
		
		jdbcTemplate.update(sql_update, target, balance.getUserId());
		
		balance.setValueBalance(getBalance(balance).getValueBalance());
		
		return balance;
	}
	
	public Balance withdrawal(Balance balance) {
		int valueBalance = balance.getValueBalance();
		int amount = balance.getAmount();
		
		int target = valueBalance - amount;
		
		jdbcTemplate.update(sql_update, target, balance.getUserId());
		
		balance.setValueBalance(getBalance(balance).getValueBalance());
		
		return balance;
	}
}
