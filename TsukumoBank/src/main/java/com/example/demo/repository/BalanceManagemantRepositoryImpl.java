package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Balance;
import com.example.demo.entity.History;

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
		String sql_getbalance =
				"SELECT Balance								" +
				"FROM									" +
				"	balance_info				" +
				"WHERE									" +
				"	User_id = ?" ;
		
		int result = jdbcTemplate.queryForObject(sql_getbalance, Integer.class, balance.getUserId());
		
		if (result >= 0) {
            balance.setValueBalance(result);
        } else {
            
        }
		
		return balance;
	}
	
	public List<History> getHistories(String userId){
		String sql_gethistories= 
				"select * from " + userId + " "
				+ "order by id desc";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql_gethistories);
		
		List<History> result = new ArrayList<History>();
		for (Map<String, Object> one : list) {
			History history = new History();
			history.setDate((Timestamp) one.get("date"));
			history.setType((String) one.get("type"));
			history.setAmount((int) one.get("amount"));
			history.setBalance((long) one.get("balance"));
			history.setRemarks((String) one.get("remarks"));
			result.add(history);
		}
		
		return result;
	}
	
	public Balance deposit(Balance balance) {
		int valueBalance = balance.getValueBalance();
		int amount = balance.getAmount();
		
		int target = valueBalance + amount;
		
		jdbcTemplate.update(sql_update, target, balance.getUserId());
		
		balance.setValueBalance(getBalance(balance).getValueBalance());
		addHistory_DW(balance);
		
		return balance;
	}
	
	public Balance withdrawal(Balance balance) {
		int valueBalance = balance.getValueBalance();
		int amount = balance.getAmount();
		
		int target = valueBalance - amount;
		
		jdbcTemplate.update(sql_update, target, balance.getUserId());
		
		balance.setValueBalance(getBalance(balance).getValueBalance());
		addHistory_DW(balance);
		
		return balance;
	}
	
	public void addHistory_DW(Balance balance) {
		String sql_addhistory_dw = 
				"insert into " + balance.getUserId() + "(Date, Type, Amount, Balance)"
				+ "values(NOW(),?,?,?)";
		jdbcTemplate.update(sql_addhistory_dw, 
									balance.getType(),
									balance.getAmount(),
									balance.getValueBalance());
		
	}
}
