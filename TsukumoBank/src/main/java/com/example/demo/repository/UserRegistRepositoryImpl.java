package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewUser;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRegistRepositoryImpl implements UserRegistRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public void add(NewUser newUser) {
		System.out.println("登録しました。");
		System.out.println(newUser);
	}
}
