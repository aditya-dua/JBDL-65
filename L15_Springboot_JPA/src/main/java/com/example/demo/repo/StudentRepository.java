package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "select s from Student s where s.name =?1")
	public List<Student> selectUsingName(String name);


	@Query(value = "select s from Student s where s.name =?1 and s.id=?2")
	public List<Student> selectUsingName(String name,int id);
	
}
