package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller
public class WelcomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "login";  // OR "welcome" if you prefer
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}
