package com.bootapplication.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootapplication.model.Flight;
import com.bootapplication.repository.FlightRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:5324/"})
public class FlightAppController {
	@Autowired
	private FlightRepository flightRepository; 
	
	@PostMapping("/flight/post")
	public Flight postFlight(@RequestBody Flight flight) {
		return flightRepository.save(flight);
	}
	
	@GetMapping("/flight/get/{source}/{destination}/{date}")
	public List<Flight> getFilteredFlights(@PathVariable("source") String source,
									@PathVariable("destination") String destination,
									@PathVariable("date") String date) {
		LocalDate departureDate = LocalDate.parse(date);
		
		System.out.println(source+" "+destination+" "+departureDate);
		
		return flightRepository.findFilteredFlights(source,destination,departureDate);
		
	}
	@GetMapping("/flight/one/{id}")
	public Flight getFlightById(@PathVariable("id") Long id) {
		Optional<Flight> optional = flightRepository.findById(id);
		
		if(!optional.isPresent())
			throw new RuntimeException("Invalid ID");
		Flight f = optional.get();
		System.out.println(f);
		return f;
	}
}
