package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
