package com.example.demo.service;

public interface UserLoginService {
	
	Boolean findByActiveTrue(String userId,String passNumber);
	
}
