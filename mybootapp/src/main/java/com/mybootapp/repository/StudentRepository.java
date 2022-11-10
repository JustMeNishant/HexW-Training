package com.mybootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query("select s from Student s where s.address.city=?1")
	List<Student> getStudentByCity(String city);

	@Query("select s from Student s where s.id=?1")
	Student fetchStudentRecord(Long sid);

}
