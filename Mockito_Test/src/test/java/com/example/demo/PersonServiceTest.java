package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

//Main class
class PersonServiceTest {

	@Mock
	private PersonRepo personRepo;
//When using Mockito Use @InjectMocks to inject
//Mocked beans to following class
	@InjectMocks
	private PersonService personService;

	@Test
	void getAllPerson() {
		// given
		Person person = new Person(1, "Rohit", "Gotham");
		Person person2 = new Person(2, "Robin", "New york");
		// When
		when(personRepo.findAll()).thenReturn(List.of(person, person2));

		// when(personRepo.findAll()).willReturn(List.of(person, person2));
		var personList = personService.getAllPerson();
		// Then
		// Make sure to import assertThat From org.assertj.core.api package
		assertThat(personList).isNotNull();
		assertThat(personList.size()).isEqualTo(2);
	}

	@Test
	void testCreateOrSaveEmployee() {
		Person person = new Person(1, "Rohit", "Gotham");

		personService.save(person);

		verify(personRepo, times(1)).save(person);
	}
}