package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.StringConstants;

@SpringBootApplication
public class L28MpUserServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(L28MpUserServiceApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepository;

	public void run(String... args) {
		
		userRepository.save(User.builder().name("Transaction Service API").
				mobile("txnservice")
				.password(new BCryptPasswordEncoder().encode("P@ass123"))
				.authorities(StringConstants.SERVICE_AUTHORITY)
				.build());
	}
}
