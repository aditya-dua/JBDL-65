package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/test")
	public String test() {
		return "Test API works!";
		
	}
	
	@GetMapping("/get")
	public Student getStudent(@RequestParam("username")String username) {
		
		System.out.println("In Get "+username);
		
		return service.getDetails(username);	
	}
	
	@GetMapping("/get1")
	public Student get() {
		
		System.out.println("In Get ");
		
		return service.getDetails("aditya");
		
	}
	
	@GetMapping("/student/roles")
	public String getStudentRoles(@RequestParam("username")String username) {
		return service.getRoles(username);
		
	}
	
	@PostMapping("/register")
	public Student register(@RequestBody Student student) {
		
		Student stu = new Student(student.getName(),student.getUsername(),encoder.encode(student.getPassword()) ,student.getRole());
		
		return service.register(stu);
		
		
	}
}
