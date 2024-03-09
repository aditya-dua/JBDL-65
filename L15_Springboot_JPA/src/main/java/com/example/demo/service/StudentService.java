package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public long count() {
		
		return studentRepository.count();
	}
	
	public List<Student> findByName(String name) {
		return studentRepository.selectUsingName(name);
	}
	
	public Student getById(int id) {
		return studentRepository.findById(id).get();
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
}
