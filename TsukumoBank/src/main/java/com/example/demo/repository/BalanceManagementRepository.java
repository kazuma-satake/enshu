package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Balance;
import com.example.demo.entity.History;
import com.example.demo.entity.Sending;

public interface BalanceManagementRepository {
	public Balance getBalance(Balance balance);
	public Balance deposit(Balance balance);
	public Balance withdrawal(Balance balance);
	public List<History> getHistories(String userId);
	public Balance send(Sending sending);
}
