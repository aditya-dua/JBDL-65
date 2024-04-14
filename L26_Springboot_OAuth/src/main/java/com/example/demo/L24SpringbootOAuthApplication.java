package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class L24SpringbootOAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(L24SpringbootOAuthApplication.class, args);
	}

}
