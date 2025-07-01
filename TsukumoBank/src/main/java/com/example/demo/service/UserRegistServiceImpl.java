package com.example.demo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.entity.NewUser;
import com.example.demo.repository.UserRegistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistServiceImpl implements UserRegistService {
	
	private final UserRegistRepository repository;
	
	private static final String SQL_PATTERN = "\\b(SELECT|INSERT|UPDATE|DELETE|FROM|WHERE|AND|OR|JOIN|DROP|UPDATE)\\b";
    private static final Pattern pattern = Pattern.compile(SQL_PATTERN, Pattern.CASE_INSENSITIVE);

    public boolean containsSQL(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

	@Override
	public String regist(NewUser newUser) {
		String userid = newUser.getUserId();
		if(!repository.userIdCheack(userid)) {
			if(!containsSQL(userid)) {
				System.out.println(newUser.getUserId());
				repository.add(newUser);
				return "complete-regist";
			} else {
				return "invalidInputUserId";
			}
		} else {
			return "faildUserRegister";
		}
	}

}
