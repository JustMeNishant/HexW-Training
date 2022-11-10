package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
