package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.NewUser;
import com.example.demo.repository.UserRegistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistServiceImpl implements UserRegistService {
	
	private final UserRegistRepository repository;

	@Override
	public void regist(NewUser newUser) {
		repository.add(newUser);
	}

}
