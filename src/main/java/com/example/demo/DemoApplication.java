package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flights;

@SpringBootApplication
@ComponentScan({ "com.example.demo.*" })

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DemoApplication {

	
 
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	

@GetMapping("/user")
	public List <Flights> getFlights() {
		// Requesting flights
		List <Flights> flightList = new ArrayList<Flights>();
		flightList.add(new Flights("FS2211", "NYC", "GRM" ));
		flightList.add(new Flights("FS2211", "LHR", "ARN" ));
		
		return flightList;
}

	
}
