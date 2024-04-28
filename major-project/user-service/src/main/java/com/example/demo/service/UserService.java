package com.example.demo.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserCreateRequest;
import com.example.demo.models.User;
import com.example.demo.repositories.UserCacheRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.StringConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserCacheRepository userCacheRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void create(UserCreateRequest userCreateRequest) throws JsonProcessingException {
		User user = userCreateRequest.to();
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		userRepository.save(user);

		JSONObject json = objectMapper.convertValue(user, JSONObject.class);

		String msg = objectMapper.writeValueAsString(json);
		kafkaTemplate.send(StringConstants.USER_CREATED_TOPIC, msg);

	}

	public User get(int userId) {
		// Adding Cache Logic here

		User user = userCacheRepository.get(userId);

		if (user == null) {
			user = userRepository.findById(userId).get();
			userCacheRepository.save(user);
		}

		return user;
	}

	@Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        return userRepository.findByMobile(username);
	    }
}