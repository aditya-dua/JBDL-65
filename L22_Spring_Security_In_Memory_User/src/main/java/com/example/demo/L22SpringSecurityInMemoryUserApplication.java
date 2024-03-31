package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L22SpringSecurityInMemoryUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(L22SpringSecurityInMemoryUserApplication.class, args);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test API works!";
	}
	
	@GetMapping("/user")
	public String userTest() {
		System.out.println("Test Start");
		return "User API works!";
	}
	@GetMapping("/home")
	public String home() {
		return "Home API works!";
	}
	
	@GetMapping("/admin")
	public String adminTest() {
		System.out.println("Test Start");
		return "Admin API works!";
	}
}
