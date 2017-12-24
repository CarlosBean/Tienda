package com.tienda.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tienda.entity.User;
import com.tienda.service.UserService;

@Controller
@RequestMapping("/clients")
public class UserController {
	
	private static final String CLIENTS_VIEW = "clients";
	private static final String CLIENTS_FORM_VIEW = "clientform";
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/showclients")
	public ModelAndView showClients() {
		ModelAndView mav = new ModelAndView(CLIENTS_VIEW);
		mav.addObject("clients", userService.listAllUsers());
		return mav;
	}
	
	@PostMapping("/addclient")
	public String addClient(@ModelAttribute(name="clientModel") User user, Model model) {
		if (userService.addClient(user) != null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		LOG.info("METHOD: addClient() -- PARAMS: " + model.toString() + ", " + user.toString());
		return "redirect:/clients/showclients";
	}
	
	@GetMapping("/clientform")
	public String redirectProductForm(@RequestParam(name = "id") Integer id, Model model) {
		User user = new User();
		if (userService.findUserById(id) != null) {
			user = userService.findUserById(id);
		}
		model.addAttribute("clientModel", user);
		LOG.info("METHOD: redirectClientForm() -- PARAMS: " + model);
		return CLIENTS_FORM_VIEW;
	}
}
