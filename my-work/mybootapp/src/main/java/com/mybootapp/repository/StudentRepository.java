package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select s from Student s where s.id=?1" )
	Student findStudentById(Long sid);

}
