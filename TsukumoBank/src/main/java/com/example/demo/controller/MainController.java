package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;
import com.example.demo.form.NewRegisterForm;



@Controller
public class MainController {
	@GetMapping("/")
	public String showMainMenustd() {
		return "/top";
	}
	@GetMapping("top")
	public String showMainMenu() {
		return "/top";
	}
	//Tsukumo
	@GetMapping("login")
	public String goLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@GetMapping("new-register")
    public String newRegister(Model model) {
        model.addAttribute("newRegisterForm", new NewRegisterForm());
        return "new-register";
    }
	
	@PostMapping("new-register-ret")
	public String newRegisterRet(@ModelAttribute NewRegisterForm newRegisterForm, Model model) {
	    model.addAttribute("newRegisterForm", newRegisterForm);
	    return "new-register";
	}
	
}
