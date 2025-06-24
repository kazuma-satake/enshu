package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.TaskForm;

@Controller
public class TaskController {
	
//	@GetMapping("select-operation")
//	public String showSelectOperation() {
//		return "select-operation";
//	}
	@PostMapping("deposit")
	public String showDeposit(@ModelAttribute TaskForm form) {
		return "deposit";
	}
	
	@PostMapping("withdrawal")
	public String showWithdrawal(@ModelAttribute TaskForm form) {
		return "withdrawal";
	}
	
	@PostMapping("sending")
	public String showSending(@ModelAttribute TaskForm form) {
		return "sending";
	}
	
	@PostMapping("result-deposit")
	public String showResultDepo(@ModelAttribute TaskForm form) {
		return "result-deposit";
	}
	@PostMapping("result-withdrawal")
	public String showResultWith(@ModelAttribute TaskForm form) {
		return "result-withdrawal";
	}
	
	@PostMapping("result-sending")
	public String showResultSend(@ModelAttribute TaskForm form) {
		return "result-sending";
	}
	

}
