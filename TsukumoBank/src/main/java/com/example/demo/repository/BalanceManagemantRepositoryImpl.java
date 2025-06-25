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
		
		return balance;
	}
}
