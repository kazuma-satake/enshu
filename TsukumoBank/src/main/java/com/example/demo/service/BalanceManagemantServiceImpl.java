package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Balance;
import com.example.demo.repository.BalanceManagementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceManagemantServiceImpl implements BalanceManagementService {
	
	private final BalanceManagementRepository repository;
	
	public Balance getValueBalance(Balance balance) {
		balance.setValueBalance(repository.getValue(balance).getValueBalance());
		return balance;
	}
}
