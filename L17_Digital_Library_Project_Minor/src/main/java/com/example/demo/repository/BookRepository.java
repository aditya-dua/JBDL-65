package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Book;
import com.example.demo.entities.Student;
import com.example.demo.entities.enums.Genre;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// @Query(value="select b from Book b where b.name like %?1")
	public List<Book> findByName(String name);

	// @Query(value="select b from Book b where b.genre = ?1")
	public List<Book> findByGenre(Genre genre);

	// @Query(value="select b from Book b where b.genre = ?1")
	// public List<Book> findByGenreString(String genre);

	@Modifying // for DML support
	@Transactional // for updating any data
	@Query("update Book b set b.my_student = ?2 where b.id = ?1 and b.my_student is null")
	void assignBookToStudent(int bookId, Student student);

	@Modifying // for DML support
	@Transactional // for updating any data
	@Query("update Book b set b.my_student = null where b.id = ?1 ")
	void unassignBook(int bookId);
}
