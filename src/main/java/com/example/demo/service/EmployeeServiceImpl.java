package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PersonAlreadyPresentException;
import com.example.demo.model.Person;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired 
	EmployeeRepository empRepo;
	@Override
	public void addEmployee(Person emp) {
		// TODO Auto-generated method stub
		
		Person person= empRepo.findByNameAndMobileNo(emp.getName(), emp.getMobileNo());
		if(!Objects.nonNull(person))
		{
			empRepo.save(emp);
		}
		else
		{
			throw new PersonAlreadyPresentException("B23", "User Already Exits");
		}
			

	}
	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		List<Person> person= empRepo.findAll();
		 
		 return person;
	}
	
	@Override
	public void deletePerson(String id) {
		// TODO Auto-generated method stub
		getById(id);
		
	}
	private Person getById(String id) {
		// TODO Auto-generated method stub
		Long id1=Long.parseLong(id);
		Optional<Person> p=empRepo.findById(id1);
		
		if(p.isPresent())
		{
			empRepo.deleteById(id1);
		}
		return null;
	}
	


}
