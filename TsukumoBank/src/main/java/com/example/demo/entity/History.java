package com.example.demo.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class History {
	private Timestamp date;
	private String type;
	private int amount;
	private long balance;
	private String remarks;
}
