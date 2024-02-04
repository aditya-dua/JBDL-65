package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L8StudentCurdApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(L8StudentCurdApiApplication.class, args);
	}

}

/**
 * API Flow:
 * http://localhost:8080/student/test
 * 
 * http://localhost:8080/student/create : {
    "name":"Aditya",
    "email":"aditya@aditya.com",
    "password":"password"
}

O/P: 
{
    "id": 9878,
    "name": "Aditya",
    "email": "aditya@aditya.com"
}

http://localhost:8080/student/get/9878
{
    "id": 9878,
    "email": "aditya@aditya.com",
    "name": "Aditya",
    "password": "password"
}
 */
