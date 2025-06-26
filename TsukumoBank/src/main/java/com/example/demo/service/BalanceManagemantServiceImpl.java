package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Balance;
import com.example.demo.repository.BalanceManagementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceManagemantServiceImpl implements BalanceManagementService {
	
	private final BalanceManagementRepository repository;
	private Balance result;
	
	public Balance controleType(Balance balance) {
		switch (balance.getType()) {
		case "showbalance": 
			result = getBalance(balance);
			break;
		case "deposit":
			result = deposit(balance);
			break;
		case "withdrawal":
			result = withdrawal(balance);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + balance.getType());
		}
		
		return result;
	}
	
	public Balance getBalance(Balance balance) {
		result = repository.getBalance(balance);
		return result;
	}
	
	public Balance deposit(Balance balance) {
		balance.setValueBalance(repository.getBalance(balance).getValueBalance());
		result = repository.deposit(balance);
		return result;
	}
	
	
	public Balance withdrawal(Balance balance) {
		balance.setValueBalance(repository.getBalance(balance).getValueBalance());
		if(balance.getValueBalance() < balance.getAmount()) return balance = null;
		
		result = repository.withdrawal(balance);
		return result;
	}
}
