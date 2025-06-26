package com.example.demo.entity;

import lombok.Data;

@Data
public class Balance {
	private String userId;
	private String type;
	private int amount;
	private int valueBalance;
}
