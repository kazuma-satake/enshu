package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LoginUser;

public interface UserLoginService {
	
	List<LoginUser> findByActiveTrue(String userId,String passNumber);
	
}
