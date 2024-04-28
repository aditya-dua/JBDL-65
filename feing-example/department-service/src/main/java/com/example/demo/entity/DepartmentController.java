package com.example.demo.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	   private DepartmentService departmentService;

	    @PostMapping
	    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
	        Department savedDepartment = departmentService.saveDepartment(department);
	        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	    }

	    @GetMapping("{id}")
	    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId){
	        Department department = departmentService.getDepartmentById(departmentId);
	        return ResponseEntity.ok(department);
	    }
}
