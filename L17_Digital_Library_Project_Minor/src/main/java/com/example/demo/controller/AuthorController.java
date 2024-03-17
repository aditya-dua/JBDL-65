package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Author;
import com.example.demo.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/author/all")
	public List<Author> findAll(){
		return authorService.findAll();
	}
}
