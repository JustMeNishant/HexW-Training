package com.mybootapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootapp.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

	@Query("select f from Flight f where f.source = ?1 and f.destination = ?2 and f.depdate = ?3")
	List<Flight> findFilteredFlights(String source, String destination, LocalDate depdate);

}
