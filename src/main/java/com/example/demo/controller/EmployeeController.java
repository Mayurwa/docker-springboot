package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PersonAlreadyPresentException;
import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.service.EmployeeService;

import antlr.StringUtils;
import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

@Autowired
private EmployeeService empservice;

private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);

	
	

@PostMapping("/saveUser")
	public  ResponseEntity<Void> create(@RequestBody Person emp)
	{
		try
		{
			LOGGER.info("inside");
			empservice.addEmployee(emp);
			
		}
		catch(PersonAlreadyPresentException ex)
		{
			throw new PersonAlreadyPresentException(ex.getCode(), ex.getMessage());
		}
	
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);

		
				// return emp.save(e);
		
	}	

	@GetMapping("/getPersons")
	public ResponseEntity<List<Person>> getAllUsers()
	{
		List<Person> person = empservice.getAllPerson();
	//	Optional<List<Person>> ofNullable = Optional.ofNullable(person);
		if(null==person || person.isEmpty())
		{
			throw new PersonNotFoundException("B11","no persons  found");
		}
		return new ResponseEntity<List<Person>>(person,HttpStatus.OK);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable("id") String id)
	{
		if(null!=id)
		{
		empservice.deletePerson(id);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
	
	
	
}
