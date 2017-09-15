package com.ATM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ATM.Service.ATMService;

@Controller
public class ATMUserController {

	@Autowired
	ATMService atmService;

	
	@RequestMapping(value = "/withdrawlPage", method = RequestMethod.GET)
	public String showTodopage() {
		System.out.println();
		return "amount_withdrawl_form";
	}

	@RequestMapping(value = "/displaynotes", method = RequestMethod.POST)
	public String showNotes(@RequestParam Integer amount, ModelMap model) {
		// int amount = 110;
		if (amount % 10 != 0) {
			model.put("errorMessage", "ERROR : Please enter the amount in multiples of 10");
			return "amount_withdrawl_form";
		}		
		String result = atmService.retrieveNotes(amount);		
		if (result.contains("ERROR")) {
			model.put("errorMessage", result);
			return "amount_withdrawl_form";
		} else {
			model.addAttribute("money", result);
			return "show_money_details"; 
		}

	}
}
