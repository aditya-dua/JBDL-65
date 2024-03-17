package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public Author createOrGet(Author author) {
		Author authorfromDb = this.authorRepository.findByEmail(author.getEmail());
		
		if(authorfromDb !=null) {
			return authorfromDb;
		}
		
		return this.authorRepository.save(author);
	
	}
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
	
	// Create the logic to update the author and find all 
}
