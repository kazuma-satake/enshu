package com.example.demo.repository;

import com.example.demo.entity.Balance;

public interface BalanceManagementRepository {
	public Balance getBalance(Balance balance);
	public Balance deposit(Balance balance);
	public Balance withdrawal(Balance balance);
}
