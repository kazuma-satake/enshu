package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.NewUser;
import com.example.demo.form.NewRegisterForm;
import com.example.demo.service.UserRegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserRegistController {
	
	private final UserRegistService service;
	
	@PostMapping("regist-review")
	public String registerInfo(@ModelAttribute NewRegisterForm form) {
		NewUser newUser = new NewUser();
		newUser.setUserId(form.getUserId());
		newUser.setPhoneNumber(form.getPhoneNumber());
		newUser.setAddress(form.getAddress());
		newUser.setPassNumber(form.getPassNumber());
		
		service.regist(newUser);
		
		return "confirm-regist";
	}
}
