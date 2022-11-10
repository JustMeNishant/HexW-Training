package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
