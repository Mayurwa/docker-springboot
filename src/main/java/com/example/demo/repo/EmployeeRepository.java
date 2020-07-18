package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;


@Repository
public interface EmployeeRepository extends JpaRepository<Person, Long>{

	Person findByNameAndMobileNo(String name, String mobileNo);

//	Optional<Person> findById(String id);

	

}
