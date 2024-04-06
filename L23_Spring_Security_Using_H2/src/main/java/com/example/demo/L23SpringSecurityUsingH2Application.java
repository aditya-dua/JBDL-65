package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class L23SpringSecurityUsingH2Application {

	public static void main(String[] args) {
		SpringApplication.run(L23SpringSecurityUsingH2Application.class, args);
	}

}
