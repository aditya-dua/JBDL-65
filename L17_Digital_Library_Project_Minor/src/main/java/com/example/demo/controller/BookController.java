package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CreateBookRequest;
import com.example.demo.entities.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/test")
	public String test() {
		return "Test API works!";
	}
	/*
	 * 
	 * URL: http://localhost:8080/book
	 * Obj: {
    "name":"JBDL-65",
    "genre":"TECHNICAL",
    "pages":100,
    "authorName":"Aditya Dua",
    "authorCountry":"India",
    "authorEmail":"aditya@aditya.com"
}
	 */
	@PostMapping("")
	public Book createBook(@RequestBody CreateBookRequest createBookRequest) {
		return bookService.create(createBookRequest);
	}
	
}
