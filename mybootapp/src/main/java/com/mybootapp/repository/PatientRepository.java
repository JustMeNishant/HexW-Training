package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
