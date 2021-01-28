package ru.vlasovmb.minprofile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AppController {

	@GetMapping("/")
	public String balancePage(Model model) {
		return "balance";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		return "register";
	}

	@GetMapping("error/403")
	public String error403Page(Model model) {
		return "error403";
	}
}