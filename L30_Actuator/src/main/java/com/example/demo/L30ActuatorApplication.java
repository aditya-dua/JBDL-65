package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class L30ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(L30ActuatorApplication.class, args);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test Works!";
	}

}
