package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

	@Mock
	private StudentRepo repo;
	
	@InjectMocks
	private StudentService service;
	
	@Test
	void getAllStudent() {
		
		Student s = new Student(1, "ADITYA", "DELHI");
		Student s2 = new Student(2, "ADITYA - 2", "DELHI");
		
		
		// This is the mocking defined
		when(repo.findAll()).thenReturn(List.of(s,s2));
		
		
		List<Student> studentList = service.getAll();
		
		assertThat(studentList).isNotNull();
		assertThat(studentList.size()).isEqualTo(2);
		
		
	}
	
	@Test
	void testCreate() {
		Student s = new Student(1, "Aditya", "Delhi");
		
		service.save(s);
		
		verify(repo,times(1)).save(s);
		
		
		when(repo.existsById(1)).thenReturn(true);
		
		
		boolean exists= service.checkIfStudentExists(1);
		
		assertThat(exists).isEqualTo(true);
		
	}
	
}
