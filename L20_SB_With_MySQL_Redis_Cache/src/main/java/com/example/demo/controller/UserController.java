package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo repo;
	
	@GetMapping("/load")
	public String load() {
		System.out.println("Load called");
		
		User aditya = new User(1, "Aditya", 10000);
		repo.save(aditya);
		
		User john = new User(2, "John", 12000);
		repo.save(john);
		
		User david = new User(3, "David", 5000);
		repo.save(david);
		
		return "Data Loaddd Suucess.";
	}
	@DeleteMapping("/{userId}")
	@CacheEvict(value="jbdl65-users" , key ="#userId")
	public String deleteByUserId(@PathVariable int userId) {
		repo.deleteById(userId);
		
		return "Success!";
	}
	
	@GetMapping("/get/{userId}")
	@Cacheable(value="jbdl65-users" , key ="#userId", condition = "#userId>1",unless = "#result.followers>12000" )
	public User getUserById(@PathVariable int userId) {
		return repo.findById(userId).get();
	}
	
	
}
