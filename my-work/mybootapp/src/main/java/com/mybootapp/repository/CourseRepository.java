package com.mybootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootapp.model.Course;
import com.mybootapp.model.Department;

public interface CourseRepository extends JpaRepository<Course, Long>{

	@Query("select c from Course c where c.department.name=?1")
	List<Course> getCourseByDepartmentName(String dname);

	@Query("select c.department from Course c where c.name=?1")
	Department getDepartmentByCourseName(String cname);

	@Query("select c from Course c where c.id=?1")
	Course findCourseById(Long cid);


}
