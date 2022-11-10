package com.mybootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootapp.model.Student;
import com.mybootapp.model.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>{

	@Query("select sc.student from StudentCourse sc where sc.course.id=?1")
	List<Student> getStudentByCourseId(Long cid);

}
