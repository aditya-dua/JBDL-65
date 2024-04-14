package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/test")
	public String home() {
		return "Test API works";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return auth.toString();
	}
}
