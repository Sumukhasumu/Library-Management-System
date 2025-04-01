package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "welcome"; // This will show the welcome.jsp page
	}
}
