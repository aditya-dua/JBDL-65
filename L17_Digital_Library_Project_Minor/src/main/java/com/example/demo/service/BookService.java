package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CreateBookRequest;
import com.example.demo.dtos.SearchBookRequest;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Student;
import com.example.demo.entities.enums.Genre;
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
	
	public void assignBookToStudent(Book book, Student student){
        bookRepository.assignBookToStudent(book.getId(), student);
    }

    public void unassignBookFromStudent(Book book){
        bookRepository.unassignBook(book.getId());
    }

	
	/*
	 * I want search book by name
	 * genre
	 * id
	 */
	
	public List<Book> search(SearchBookRequest searchBookRequest) throws Exception{
		boolean isValidRequest = searchBookRequest.validate();
		if(!isValidRequest) {
			throw new Exception("Invalid Request");
		}
		
		switch (searchBookRequest.getSearchKey()) {
		case "name": 
			return bookRepository.findByName(searchBookRequest.getSearchValue());
		case "genre": 
			return bookRepository.findByGenre(Genre.valueOf(searchBookRequest.getSearchValue()));
		case "id":
			Book book = bookRepository.findById(Integer.parseInt(searchBookRequest.getSearchValue())).orElse(null);
            return Arrays.asList(book);
		default:
			throw new Exception("invalid search key");
		}
	}
	
	/*public List<Book> search( String key, String value) throws Exception{
		
		
		
		switch (key) {
		case "name": 
			return bookRepository.findByName(value);
		case "genre": 
			
			return bookRepository.findByGenre(Genre.valueOf(value));
		case "id":
			//return new ArrayList<Book>().add(bookRepository.findById(Integer.valueOf(value)).get());
		}
		return null;
	}*/
	
	public List<Book> get(){
		return bookRepository.findAll();
	}
	
	// create the logic to delete the books
}
