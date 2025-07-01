package com.example.demo.form;

import lombok.Data;

@Data
public class SendingForm {
	private String userId;
	private int amount;
	private String forwarding_userId;
}
