package com.tienda.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	public static final Log LOG = LogFactory.getLog(LoginController.class);
	
	public static final String LOGIN_VIEW = "login";
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false)String error,
			@RequestParam(name="logout", required=false)String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
		model.addAttribute("error", error); 
		model.addAttribute("logout", logout); 
		LOG.info("Returning to login view");
		return LOGIN_VIEW;
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		LOG.info("METHOD: loginCheck()");
		return "redirect:/contacts/showcontacts";
	}

}
