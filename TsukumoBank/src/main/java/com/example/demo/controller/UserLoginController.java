package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Balance;
import com.example.demo.form.LoginForm;
import com.example.demo.service.UserLoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserLoginController{
	
	private final UserLoginService service;
	
	@PostMapping("user_search")
	private String userSearch(@ModelAttribute LoginForm form,Model model) {
		
		Boolean result = service.findByActiveTrue(form.getUserId(),form.getPassNumber());
		
		if(result) {
			Balance balance = new Balance();
			balance.setUserId(form.getUserId());
			model.addAttribute("userId", form.getUserId());
			model.addAttribute("balanceForm", balance);
			return "select-operation";
		} else {
			return "user-notFound";
		}	
	}
}