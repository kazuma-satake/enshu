package com.example.demo.repository;

public interface UserLoginRepository {
	
	public Boolean findByActiveTrue(String userId,String passNumber);
	
}
