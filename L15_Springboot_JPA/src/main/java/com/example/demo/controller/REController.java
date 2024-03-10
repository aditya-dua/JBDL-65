package com.example.demo.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/re")
public class REController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String test() {
		return "Test Works";
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStduentById(@PathVariable int id) {
		
		Map<String,Object> map = new LinkedHashMap();
		
		if(id<0) {
			map.put("status", 0);
			map.put("message", "Invalid Id passed, id cannot be less than 0.");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}else {
			try {
				Student s = studentService.getById(id);
				map.put("status", 1);
				map.put("message", "Success");
				map.put("data", s);
				return new ResponseEntity<>(map, HttpStatus.OK);
			}catch (Exception e) {
				// TODO: handle exception
				
				map.put("status", 0);
				map.put("message", "Student doesnot exists for ID: "+id);
				map.put("error", e.getMessage());
				return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			}
			
			
		}
	}
	
	
	
}
