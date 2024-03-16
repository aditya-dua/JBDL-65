package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CreateBookRequest;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorService authorService;
	
	public Book create(CreateBookRequest createBookRequest) {
		Book book = createBookRequest.to();
		Author author = authorService.createOrGet(book.getMy_author());
		book.setMy_author(author);
		return bookRepository.save(book);
	}
}
