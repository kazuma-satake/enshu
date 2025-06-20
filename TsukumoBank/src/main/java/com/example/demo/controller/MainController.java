package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//http://localhost:8080/top

@Controller
public class MainController {
	@GetMapping("top")
	public String showMainMenu() {
		return "top";
	}
	//Tsukumo
	@GetMapping("login")
	public String goLogin() {
		return "login";
	}
	
	@GetMapping("new-register")
	public String newRegister() {
		return "new-register";
	}
	
}
