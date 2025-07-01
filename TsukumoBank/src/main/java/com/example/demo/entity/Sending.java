package com.example.demo.entity;

import lombok.Data;

@Data
public class Sending {
	private String userId;
	private int amount;
	private String forwarding_userId;
}
