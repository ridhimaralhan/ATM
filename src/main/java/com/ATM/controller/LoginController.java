package com.ATM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ATM.Service.ATMService;
import com.ATM.Service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService lsService;

	@Autowired
	ATMService atmService;//

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (lsService.validateAdmin(name, password)) {
			model.addAttribute("Notes", atmService.CheckStatus());
			return "welcomeadmin";
		} else
			return "welcomeuser";

	}
}
