package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UserLoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {
	
	private final UserLoginRepository repository;
	
	@Override
	public Boolean findByActiveTrue(String userId, String passNumber) {
		
		Boolean result = repository.findByActiveTrue(userId, passNumber);
		
		return result;
	}

}
