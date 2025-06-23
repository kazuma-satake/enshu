package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.NewRegisterForm;

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
    public String newRegister(Model model) {
        model.addAttribute("newRegisterForm", new NewRegisterForm());
        return "new-register";
    }
	
}
