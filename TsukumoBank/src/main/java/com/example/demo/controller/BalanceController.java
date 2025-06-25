package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private final BalanceManagementService bs;
	
	@PostMapping("balance")
	public String showBalance(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		
		balance.setUserId(form.getUserId());
		
		int result = bs.getValueBalance(balance).getValueBalance();
		
		balance.setValueBalance(result);
		
		model.addAttribute("balanceForm", balance);
		return "result-balance";
	}
}
