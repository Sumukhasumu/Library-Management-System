package com.library.controller;

import com.library.model.Users;
import com.library.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// GET request to show login page
	@GetMapping("/login")
	public String showLoginForm() {
		return "login"; // This will show the login.jsp page
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		Users users = userService.authenticate(username, password);
		if (users != null) {
			return "redirect:/welcome";
		}
		model.addAttribute("error", "Invalid credentials");
		return "login";
	}

	// GET request to show registration page
	@GetMapping("/register")
	public String showRegisterForm() {
		return "register"; // This will show the register.jsp page
	}

	// POST request to handle registration
	@PostMapping("/register")
	public String register(@ModelAttribute Users users, Model model) {
		try {
			userService.addUser(users); // Save user to the database
			model.addAttribute("message", "User registered successfully. Please login.");
			return "redirect:/login"; // Redirect to login page after successful registration
		} catch (Exception e) {
			model.addAttribute("error", "Error registering user. Please try again.");
			return "register"; // Stay on the registration page if registration fails
		}
	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate(); // Invalidate the session
		return "redirect:/login"; // Redirect to the login page
	}
}
