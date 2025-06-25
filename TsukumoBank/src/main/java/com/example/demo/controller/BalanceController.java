package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Balance;
import com.example.demo.service.BalanceManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BalanceController {
	
	@Autowired
	private final BalanceManagementService bs;
	
	@PostMapping("balance")
	public String showBalance(Model model) {
		int result = 0;
		Balance balance = new Balance();
		
//		result = bs.getValueBalance(null).getValueBalance();
		
		balance.setValueBalance(result);
		
		model.addAttribute("balanceForm", balance);
		System.out.println(result);
		return "result-balance";
	}
}
