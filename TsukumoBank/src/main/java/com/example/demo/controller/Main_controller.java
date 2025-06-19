package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_controller {
	@GetMapping("top")
	public String showMainMenu() {
		return "top";
	}
	//Tsukumo
}
