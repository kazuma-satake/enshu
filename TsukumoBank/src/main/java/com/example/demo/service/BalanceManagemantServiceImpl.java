package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Balance;
import com.example.demo.entity.History;
import com.example.demo.entity.Sending;
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
			balance.setType("預入");
			result = deposit(balance);
			break;
		case "withdrawal":
			balance.setType("引出");
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
	
	public Balance send(Sending sending) {
		return repository.send(sending);
	}
	
	public List<History> getHistory(String userId){
		List<History> list = repository.getHistories(userId);
		return list;
	}
}
