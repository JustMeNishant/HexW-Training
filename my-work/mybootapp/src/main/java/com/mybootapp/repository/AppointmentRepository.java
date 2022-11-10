package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
