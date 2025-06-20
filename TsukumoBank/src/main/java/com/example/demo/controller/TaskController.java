package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.NewRegister;

@Controller
public class TaskController {
	
	@PostMapping("select-operation")
	public String registerInfo(@ModelAttribute NewRegister form) {
		return "select-operation";
	}
}
