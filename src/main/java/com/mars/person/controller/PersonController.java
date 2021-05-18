package com.mars.person.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mars.person.entity.Person;
import com.mars.person.service.PersonService;
import com.sun.tools.sjavac.Log;

import lombok.extern.log4j.Log4j;


@Log4j
@RestController
@RequestMapping(value= "/mars")
public class PersonController {
	
	
	
	@Autowired
	private PersonService service;
	
	@PostMapping("/addPerson")
	public String addPerson (@RequestBody Person person) {
		service.addPerson(person);
		Log.info("Person Added");
		return "Added Person";
	}
	
	@GetMapping("/getPersons")
	public List<Person> getPersons () {
		Log.info("In side Get ");
		return service.getPersons();
	}
	
	@PutMapping("/editPerson")
	public String editPerson (@RequestBody Person person) {
		service.editPerson(person);
		Log.info("Person Edited");
		return "Edited Person";
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public String deletePerson (@PathVariable long id) {
		service.deletePerson(id);
		Log.info("Person Deleted");
		return "Deleted Person";
	}
	

	@GetMapping("/getCount")
	public int getPersonCount () {
		Log.info("In side count");
		return service.getPersons().size();
	}
	
}
