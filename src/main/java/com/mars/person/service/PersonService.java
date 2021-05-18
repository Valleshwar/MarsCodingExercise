package com.mars.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.person.entity.Person;
import com.mars.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public void addPerson(Person person) {
		repository.save(person);
	}
	
	public List<Person> getPersons() {
		return repository.findAll();
		
	}
	
	public void editPerson(Person person) {
		Optional<Person> oldValue = repository.findById(person.getId());
		oldValue.ifPresent((p) -> {
			p.setFirstName(person.getFirstName());
			p.setSurName(person.getSurName());
			repository.save(p);
		});
	}
	public void deletePerson(long id) {
		Optional<Person> oldValue = repository.findById(id);
		oldValue.ifPresent(p -> repository.delete(p));
	}
	
	
}
