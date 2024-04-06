package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public Student register(Student student) {
		return studentRepo.save(student);
	}
	
	public Student getDetails(String username) {
		return studentRepo.findByUsername(username);
	}
	
	public String getRoles(String username) {
		return studentRepo.findByUsername(username).getRole();
	}
}
