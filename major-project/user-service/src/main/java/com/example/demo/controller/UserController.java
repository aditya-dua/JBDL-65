package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserCreateRequest;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("")
	public void createUser(@RequestBody UserCreateRequest createRequest) throws JsonProcessingException {
		userService.create(createRequest);
	}

	@GetMapping("/details")
	public User getUserDetails(@RequestParam("userId") int userId) {
		return userService.get(userId);
	}

	// Other Apps would get the user details on the basis of mobile
	@GetMapping("/mobile/{mobileId}")
	public User getUserDetailsByMob(@PathVariable("mobileId") String mobile) {
		return (User) userService.loadUserByUsername(mobile);
	}

	/*
	 * Sample Request and Response:
	 */
	/*
	 * 1. Creation: localhost:8080/user { "name":"Aditya",
	 * "email":"adityadua1992@gmail.com", "mobile":"8826669888", "password":"aditya"
	 * }
	 * 
	 * 2. Get by Mobile: localhost:8080/user/mobile/8826669888 Response: { "userId":
	 * 1, "name": "Aditya", "email": "adityadua1992@gmail.com", "mobile":
	 * "8826669888", "password": "aditya", "createdOn":
	 * "2024-04-21T16:04:19.542+00:00", "updatedOn":
	 * "2024-04-21T16:04:19.542+00:00", "authorities": "usr" }
	 * 
	 * 3. Get by UserId localhost:8080/user/details?userId=1 { "userId": 1, "name":
	 * "Aditya", "email": "adityadua1992@gmail.com", "mobile": "8826669888",
	 * "password": "aditya", "createdOn": "2024-04-21T16:04:19.542+00:00",
	 * "updatedOn": "2024-04-21T16:04:19.542+00:00", "authorities": "usr" }
	 */
	
	
}
