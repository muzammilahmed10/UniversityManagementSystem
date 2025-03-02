package com.web.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.demo.services.UnivUserService;

@Controller
@RequestMapping("/api")
public class UnivUserController {

	@Autowired
	UnivUserService univserv;
	
	@RequestMapping("/")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/univ/login")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {
		String role = univserv.authenticateUser(email, password);
		
		if(role.equalsIgnoreCase("student")) {
			return "studentdashboard";
		}
		else if(role.equalsIgnoreCase("teacher")) {
			return "teacherdashboard";
		}
		else {
			return "invalid";
		}
		
	}
}
