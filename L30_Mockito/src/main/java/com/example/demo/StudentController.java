package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentController {

	private final StudentService service;
	
	
}
