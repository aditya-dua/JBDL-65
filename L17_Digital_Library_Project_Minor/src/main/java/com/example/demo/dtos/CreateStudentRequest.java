package com.example.demo.dtos;

import java.util.Date;

import com.example.demo.entities.Student;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String contact;
	
	// 365*1000*24*60*60
	
	public Student to() {
		return Student.builder()
				.name(name)
				.contact(contact)
				.validity(new Date(System.currentTimeMillis()+31536000000l))
				.build();
	}
}
