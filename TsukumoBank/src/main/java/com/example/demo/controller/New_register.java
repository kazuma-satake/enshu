package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.NewRegister;

@Controller
public class New_register {
	
	@PostMapping("regist-review")
	public String registerInfo(@ModelAttribute NewRegister form) {
		
		return "confirm-regist";
	}
}
