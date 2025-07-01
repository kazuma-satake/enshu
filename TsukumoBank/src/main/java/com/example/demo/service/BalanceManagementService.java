package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Balance;
import com.example.demo.entity.History;
import com.example.demo.entity.Sending;

public interface BalanceManagementService {
	public Balance controleType(Balance balance);
	public Balance getBalance(Balance balance);
	public Balance deposit(Balance balance);
	public Balance withdrawal(Balance balance);
	public List<History> getHistory(String userId);
	public Balance send(Sending sending);
}
