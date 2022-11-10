package com.mybootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.dto.CourseDto;
import com.mybootapp.model.Course;
import com.mybootapp.model.Department;
import com.mybootapp.repository.CourseRepository;
import com.mybootapp.repository.DepartmentRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@PostMapping("/course/insert")
	public Course insertCourse(@RequestBody Course course) {
		Department department = new Department();
		Department departmentDB = new Department();
		departmentDB = departmentRepository.findByName(course.getDepartment().getName());
		
		if(departmentDB == null) {
			department = course.getDepartment();
		}
		else{
			department = departmentDB;
		}
		
		 department = departmentRepository.save(department);
		 course.setDepartment(department);
		 
		 return courseRepository.save(course);
	}
	
	@PostMapping("/course/post")
	public Course postCourse(@RequestBody CourseDto courseDto) {
		Course course = new Course();
		Department department = new Department();
		Department departmentDB = new Department();
		
		course.setName(courseDto.getCourseName());
		course.setCredits(courseDto.getCredits());
		course.setFee(courseDto.getCredits());
		department.setName(courseDto.getDepartmentName());
		
		departmentDB = departmentRepository.findByName(department.getName());
		
		if (departmentDB == null) {
			department = departmentRepository.save(department);
		}
		else {
			department = departmentDB;
		}
		
		course.setDepartment(department);
		
		return courseRepository.save(course);
	}
	
	@GetMapping("/course/department/{dname}")
	public List<Course> getCourseByDepartmentName(@PathVariable("dname") String dname){
		List<Course> list = courseRepository.getCourseByDepartmentName(dname);
		return list; 
	}
	
	@GetMapping("/department/course/{cname}")
	public Department getDepartmentByCourseName(@PathVariable("cname") String cname) {
		Department department = courseRepository.getDepartmentByCourseName(cname);
		return department;
	}

}
