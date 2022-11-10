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
		/* check if department name already exists*/
		Department department = departmentRepository.findByName(course.getDepartment().getName());
		
		if(department == null) {
			/* save department in DB */
			department = departmentRepository.save(course.getDepartment());
		}
		
		/* Attach department to course */
		course.setDepartment(department);
		
		/* save course */
		return courseRepository.save(course);
	}
	
	@PostMapping("/course/post")
	public Course postCourse(@RequestBody CourseDto courseDto) {
		/*Extract info from dto and save it in course & department object */
		Course course = new Course(); 
		course.setName(courseDto.getName());
		course.setCredits(courseDto.getCredits());
		course.setFee(courseDto.getFee());
		
		Department department = new Department(); 
		department.setName(courseDto.getDepartmentName());
	
		/* check if department name already exists*/
		Department departmentDB = departmentRepository.findByName(department.getName());
		
		if(departmentDB == null) {
			/* save department in DB */
			department = departmentRepository.save(department);	
		}
		else {
			department = departmentDB; 
		}	 
		/* Attach department to course */
		course.setDepartment(department);
		
		/* save course */
		return courseRepository.save(course);
	}
	
	/* 
	 * display all courses on the basis of department name.
	 */
	@GetMapping("/course/department/{dname}")
	public List<Course> getCourseByDepartmentName(@PathVariable("dname") String dname){
		List<Course> list = courseRepository.getCourseByDepartmentName(dname);
		return list; 
	}
	
	/* 
	 * Display department on the basis of course name
	 */
	@GetMapping("/department/course/{cname}")
	public Department getDepartmentByCourseName(@PathVariable("cname") String cname) {
		Department department = courseRepository.getDepartmentByCourseName(cname);
		return department;
	}
	
	/*
	 * Display department on the basis of course ID. 
	 */
	
	/*
	 * Display courses on the basis of department ID.
	 */
}








