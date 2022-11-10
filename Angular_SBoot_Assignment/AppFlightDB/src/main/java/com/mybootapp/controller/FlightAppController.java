package com.mybootapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Flight;
import com.mybootapp.repository.FlightRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class FlightAppController {
	@Autowired
	private FlightRepository flightRepository; 
	
	@PostMapping("/flight/post")
	public Flight postFlight(@RequestBody Flight flight) {
		System.out.println("this function executed");
		return flightRepository.save(flight);
	}
	@GetMapping("/flight/")
	public String Displaypage() {
		return("This is working?");
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
	@DeleteMapping("/flight/delete/{id}")
	public void deleteFlightbyID(@PathVariable("id") long id) {
		flightRepository.deleteById(id);
		}
	
	@PutMapping("/flight/update/{id}")
	public Flight updateFlightbyID(@PathVariable("id") long id, @RequestBody Flight flight) {
		Optional<Flight> option=flightRepository.findById(id);
		if(!option.isPresent())
			throw new RuntimeException("Invalid Id");
		Flight f= option.get();
		Flight oldf= option.get();
		oldf.setAdultfare(flight.getAdultfare());
		oldf.setArrdate(flight.getArrdate());
		oldf.setArrtime(flight.getArrtime());
		oldf.setChildfare(flight.getChildfare());
		oldf.setDepdate(flight.getDepdate());
		oldf.setDeptime(flight.getDeptime());
		oldf.setDestination(flight.getDestination());
		oldf.setDuration(flight.getDuration());
		oldf.setName(flight.getName());
		oldf.setSeats(flight.getSeats());
		oldf.setSource(flight.getSource());
		return(flightRepository.save(oldf));
		
	}
}