package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private static final String MAIN_VIEW = "main";
	
	@GetMapping("/showmain")
	public ModelAndView showMain() {
		ModelAndView mav = new ModelAndView(MAIN_VIEW);
		return mav;
	}
}
