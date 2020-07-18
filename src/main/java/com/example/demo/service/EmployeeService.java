package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

public interface EmployeeService {

	
	public void addEmployee(Person emp);

	public List<Person> getAllPerson();

	//public void delete(String id);

	public void deletePerson(String id);
}
