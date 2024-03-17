package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CreateStudentRequest;
import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("")
	public Student create(@RequestBody CreateStudentRequest createStudentRequest) {
		
		return studentService.create(createStudentRequest);
	}
	
	@GetMapping("/{StudentId}")
	public Student get(@PathVariable int  StudentId) {
		
		return studentService.get(StudentId);
	}
	
	@DeleteMapping("")
	public Student delete(@PathVariable int  StudentId) {
		
		return studentService.delete(StudentId);
	}
}
