package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Balance;
import com.example.demo.entity.History;
import com.example.demo.entity.Sending;
import com.example.demo.form.BalanceForm;
import com.example.demo.form.SendingForm;
import com.example.demo.service.BalanceManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BalanceController {
	
	private final BalanceManagementService bs;
	
	/***************************************************/
	/************  ID・タスクタイプset関数  ************/
	/***************************************************/
	public Balance common(BalanceForm form, String type) {
		Balance balance = new Balance();
		
		balance.setUserId(form.getUserId());
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
	
	/********************************************/
	/************  入金コントローラ  ************/
	/********************************************/
	@PostMapping("deposit")
	public String deposit(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		balance = common(form, "deposit");
		model.addAttribute("balanceForm", balance);
		return "deposit";
	}
	@PostMapping("confirm-deposit")
	public String confirmDeposit(@ModelAttribute BalanceForm form, Model model) {
		return "confirm-deposit";
	}
	@PostMapping("result-deposit")
	public String resultDeposit(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		balance.setUserId(form.getUserId());
		balance.setType(form.getType());
		balance.setAmount(form.getAmount());
		
		Balance result = bs.controleType(balance);
		
		model.addAttribute("balanceForm", result);
		return "result-deposit";
	}
	
	/********************************************/
	/************  出金コントローラ  ************/
	/********************************************/
	@PostMapping("withdrawal")
	public String withdrawal(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		balance = common(form, "withdrawal");
		model.addAttribute("balanceForm", balance);
		return "withdrawal";
	}
	@PostMapping("confirm-withdrawal")
	public String confirmWithdrawal(@ModelAttribute BalanceForm form, Model model) {
		return "confirm-withdrawal";
	}
	@PostMapping("result-withdrawal")
	public String resultWithdrawal(@ModelAttribute BalanceForm form, Model model) {
		Balance balance = new Balance();
		balance.setUserId(form.getUserId());
		balance.setType(form.getType());
		balance.setAmount(form.getAmount());
		
		Balance result = bs.controleType(balance);
		if(result == null) return "overdrawn";
		
		model.addAttribute("balanceForm", result);
		return "result-withdrawal";
	}
	
	
	/********************************************/
	/************  送金コントローラ  ************/
	/********************************************/
	@PostMapping("sending") 
	public String sending(@ModelAttribute SendingForm form, Model model) {
		Sending sending = new Sending();
		sending.setUserId(form.getUserId());
		model.addAttribute("sendingForm", sending);
		return "sending";
	}
	@PostMapping("confirm-sending") 
	public String confirmSending(@ModelAttribute SendingForm form, Model model) {
		Balance balance = new Balance();
		balance.setUserId(form.getUserId());
		
		balance = bs.getBalance(balance);
		
		if (form.getAmount() > bs.getBalance(balance).getValueBalance()) {
			return "overdrawn";
		}
		return "confirm-sending";
	}
	@PostMapping("result-sending") 
	public String resultSending(@ModelAttribute SendingForm form, Model model) {
		Sending sending = new Sending();
		sending.setUserId(form.getUserId());
		sending.setAmount(form.getAmount());
		sending.setForwarding_userId(form.getForwarding_userId());
		
		Balance result = bs.send(sending);
		
		model.addAttribute("sendingForm", sending);
		model.addAttribute("balanceForm", result);
		return "result-sending";
	}
	
	
	/************************************************/
	/************  取引履歴コントローラ  ************/
	/************************************************/
	@PostMapping("history")
	public String showHistory(@ModelAttribute BalanceForm form, Model model) {
		String userId = form.getUserId();
		List<History> result_List = bs.getHistory(userId);
		model.addAttribute("historyList", result_List);
		return "history";
	}
}
