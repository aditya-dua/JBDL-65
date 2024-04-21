package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserCreateRequest;
import com.example.demo.models.User;
import com.example.demo.repositories.UserCacheRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserCacheRepository userCacheRepository;
	
	public void create(UserCreateRequest userCreateRequest) {
		User user = userCreateRequest.to();
		
		userRepository.save(user);
		
		// Now we have 2 micro service i.e. User and Wallet 
		// User calls the API for User Creation...should this create automatically create wallet?
		// It should automatically create Wallet
		// Wallet creation could take 2-3 seconds.
		// This is a kafka use case becuase we dont want user to wait 2-3 secs for wallet creation
		// Kafka Producer
	}
	
	
	public User get(int userId) {
		// Adding Cache Logic here
		
		User user = userCacheRepository.get(userId);
		
		if(user == null) {
			user = userRepository.findById(userId).get();
			userCacheRepository.save(user);
		}
		
		return user;
	}
	
	public User loadUserByUsername(String username) {
		return userRepository.findByMobile(username);
	}
}
