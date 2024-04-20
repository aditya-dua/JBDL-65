package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L27SpringCloudLbServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(L27SpringCloudLbServerApplication.class, args);
	}
	
	@Value("${server.instance.id}")
	String instanceId;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from ::"+instanceId;
	}
	

}
