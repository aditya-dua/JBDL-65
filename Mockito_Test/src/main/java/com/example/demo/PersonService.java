package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service

//Class
public class PersonService {
//No need to use @Autowired when using Constructor Injection 
//Dependencies are final 

	private final PersonRepo repo;

	public PersonService(PersonRepo repo) {
		// this keyword refers to current instance
		this.repo = repo;
	}

	public List<Person> getAllPerson() {
		return repo.findAll();
	}
	
	public Person save(Person p) {
		return repo.save(p);
	}

}