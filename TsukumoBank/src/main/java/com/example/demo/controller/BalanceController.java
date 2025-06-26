package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Balance;
import com.example.demo.form.BalanceForm;
import com.example.demo.service.BalanceManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BalanceController {
	
	private final BalanceManagementService bs;
	
	//共通処理
	public Balance common(BalanceForm form, String type) {
		Balance balance = new Balance();
		
		balance.setUserId(form.getUserId());
		System.out.println(balance.getUserId());
		balance.setType(type);
		
		return balance;
	}
	
	@PostMapping("balance")
	public String showBalance(@ModelAttribute BalanceForm form, Model model) {	
		Balance balance = common(form, "showbalance");
		
		Balance result = bs.controleType(balance);
		
		model.addAttribute("balanceForm", result);
		return "result-balance";
	}
	
	@PostMapping("deposit")
	public String deposit(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		balance = common(form, "deposit");
		model.addAttribute("balanceForm", balance);
		return "deposit";
	}
	
	@PostMapping("confirm-deposit")
	public String confirmDeposit(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		balance.setUserId(form.getUserId());
		balance.setType(form.getType());
		balance.setAmount(form.getAmount());
		
		Balance result = bs.controleType(balance);
		
		model.addAttribute("balanceForm", result);
		return "confirm-deposit";
	}
	
	@PostMapping("result-deposit")
	public String resultDeposit(@ModelAttribute BalanceForm form, Model model) {
		System.out.println(form);
		model.addAttribute("balanceForm", form);
		return "result-deposit";
	}
//	
//	@PostMapping("withdrawal")
//	public String withdrawal(@ModelAttribute BalanceForm form, Model model) {
//		model.addAttribute("taskForm", new TaskForm());
//		return "deposit";
//	}
}
