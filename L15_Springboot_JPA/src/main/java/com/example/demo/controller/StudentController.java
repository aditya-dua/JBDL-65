package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/test")
	public String test() {
		
		return "Test API works!";
	}
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
}
