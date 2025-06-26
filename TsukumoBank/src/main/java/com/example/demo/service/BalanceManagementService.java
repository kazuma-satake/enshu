package com.example.demo.service;

import com.example.demo.entity.Balance;

public interface BalanceManagementService {
	public Balance controleType(Balance balance);
	public Balance getBalance(Balance balance);
	public Balance deposit(Balance balance);
	public Balance withdrawal(Balance balance);
}
