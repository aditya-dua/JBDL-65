package com.example.demo;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

	@GetMapping("/principal")
	public Principal retrivePrincipal(Principal principal) {
		return principal;
	}
}
