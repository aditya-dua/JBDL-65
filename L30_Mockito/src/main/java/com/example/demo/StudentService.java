package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	
	private final StudentRepo repo;
	
	public Student save(Student s) {
		return repo.save(s);
	}
	
	public List<Student> getAll(){
		return repo.findAll();
		
	}
	
	public boolean checkIfStudentExists(int id) {
		return repo.existsById(id);
	}
	
}
