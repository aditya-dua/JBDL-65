package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	@Query(value = "select a from Author a where a.email = ?1")
	Author findByEmail(String email);
}
