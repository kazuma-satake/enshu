package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.TaskForm;

@Controller
public class TaskController {
	
//	@GetMapping("select-operation")
//	public String showSelectOperation() {
//		return "select-operation";
//	}
	@GetMapping("deposit")
	public String showDeposit(Model model) {
		model.addAttribute("taskForm", new TaskForm());
		return "deposit";
	}
	
	@PostMapping("result-deposit")
	public String showResultDepo(@ModelAttribute TaskForm form, Model model) {
		model.addAttribute("taskForm", form);
		return "result-deposit";
	}
	
	@GetMapping("withdrawal")
	public String showWithdrawal(Model model) {
		return "withdrawal";
	}
	
	@PostMapping("result-withdrawal")
	public String showResultWith(@ModelAttribute TaskForm form) {
		return "result-withdrawal";
	}
	
	@GetMapping("sending")
	public String showSending(Model model) {
		return "sending";
	}
	
	@PostMapping("result-sending")
	public String showResultSend(@ModelAttribute TaskForm form) {
		return "result-sending";
	}
}
