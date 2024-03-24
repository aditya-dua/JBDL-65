package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.repo.ProductDAORepo;

@SpringBootApplication
@RestController
public class L20SbWithRedisApplication {

	
	@Autowired
	ProductDAORepo dao;
	
	public static void main(String[] args) {
		SpringApplication.run(L20SbWithRedisApplication.class, args);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test API works";
	}
	
	@PostMapping("/")
	public Product save(@RequestBody Product product ) {
		return dao.save(product);
	}
	
	@GetMapping("/all")
	public List<Object> getAll() {
		return dao.getAll();
	}
	
	

}
