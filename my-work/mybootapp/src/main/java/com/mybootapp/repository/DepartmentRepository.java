package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByName(String name);

}
