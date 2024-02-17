package com.example.demo.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentPostRequestModel;
import com.example.demo.model.StudentPostResponseModel;

@Service
public class StudentService {

	HashMap<Integer, Student> studentHM;
	
	
	
	public StudentPostResponseModel create(StudentPostRequestModel request) {
		if(studentHM == null) {
			studentHM = new HashMap<Integer, Student>();
		}
		Student s = new Student(request.getEmail(), request.getName(), request.getPassword());
		s.setId(getRandomNumber());
		if(studentHM.containsKey(s.getId())) {
			s.setId(getRandomNumber());
		}
		studentHM.put(s.getId(), s);
		
		StudentPostResponseModel response = new StudentPostResponseModel(s.getId(), s.getName(), s.getEmail());
		
		return response;
		
	}
	
	public StudentPostResponseModel update(int id,StudentPostRequestModel request) {
		if(studentHM == null) {
			studentHM = new HashMap<Integer, Student>();
		}
		
		Student s = new Student(request.getEmail(), request.getName(), request.getPassword());
		
		studentHM.put(id, s);
		
		StudentPostResponseModel response = new StudentPostResponseModel(s.getId(), s.getName(), s.getEmail());
		
		return response;
		
	}
	
	public Student getStudent(int id) {
		Student s = null;
		if(studentHM == null) {
			System.out.println("HashMap is not created yet.");
		}
		if(studentHM.containsKey(id)) {
			s = studentHM.get(id);
		}
		
		return s;
		
	}
	
	public ArrayList<Student> getAll() {
		
		ArrayList<Student> list = new ArrayList<Student>();
		if(studentHM == null) {
			System.out.println("HashMap is not created yet.");
		} 
		for (Map.Entry<Integer, Student> entry : studentHM.entrySet()) {
			
			list.add(entry.getValue());
			
		}
		
		
		return list;
		
	}
	
	
	public Student deleteStudent(int id) {
		Student temp =null;
		if(studentHM == null) {
			System.out.println("HashMap is not created yet.");
		}else if(studentHM.containsKey(id)){
			temp = studentHM.remove(id);
		} else {
			System.out.println("Student Doesnot Exists.");
		}
		return temp;
	}
	
	private int getRandomNumber() {
		int min =1, max = 10000;
	    return (int) ((Math.random() * (max - min)) + min);
	}

}
