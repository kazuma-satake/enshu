package com.example.demo.form;

import lombok.Data;

@Data
public class BalanceForm {
	private String userId;
	private String type;
	private int amount;
	private int valueBalance;
}
