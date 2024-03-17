package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CreateStudentRequest;
import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student create(CreateStudentRequest createStudentRequest) {
		Student student = createStudentRequest.to();
		return studentRepository.save(student);
	}
	
	public Student get(int  StudentId) {
		
		return studentRepository.findById(StudentId).orElse(null);
	}
	
	
	public Student delete( int  StudentId) {
		Student student = this.get(StudentId);
		studentRepository.delete(student);
		return student;
	}
	
	
	
}

