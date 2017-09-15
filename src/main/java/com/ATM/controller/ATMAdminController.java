package com.ATM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ATM.Service.ATMService;

@Controller
public class ATMAdminController {

	@Autowired
	ATMService atmService;// = new LoginService();

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "AdminActions";
	}

	@RequestMapping(value = "/AddNotesPage", method = RequestMethod.GET)
	public String showAddNotesPage() {
		return "addNotes_admin";
	}

	@RequestMapping(value = "/removeNotesPage", method = RequestMethod.GET)
	public String showRemoveNotesPage() {
		return "removeNotes_admin";
	}

	@RequestMapping(value = "/addNotes", method = RequestMethod.POST)
	public String AddNotes(@RequestParam Integer Denomination, @RequestParam Integer Count, ModelMap model) {
		String result = atmService.addNotes(Denomination, Count);		
		model.put("Success", result);
		return "addNotes_admin";
	}

	@RequestMapping(value = "/removeNotes", method = RequestMethod.POST)
	public String removeNotes(@RequestParam Integer Denomination, @RequestParam Integer Count, ModelMap model) {
		String result = atmService.removeNotes(Denomination, Count);
		model.put("Success", result);
		return "removeNotes_admin";
	}

}
