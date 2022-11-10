package com.mybootapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Course;
import com.mybootapp.model.Student;
import com.mybootapp.model.StudentCourse;
import com.mybootapp.repository.CourseRepository;
import com.mybootapp.repository.StudentCourseRepository;
import com.mybootapp.repository.StudentRepository;

@RestController
public class StudentCourseController {

	@Autowired
	private StudentCourseRepository studentCourseRepository;
	@Autowired
	private StudentRepository studentRepository; 
	@Autowired
	private CourseRepository courseRepository; 
	/*
	 display student info on the basis of course id
	 */
	@GetMapping("/student/course/{cid}")
	public List<Student> getStudentByCourseId(@PathVariable("cid") Long cid) {
		List<Student> list = studentCourseRepository.getStudentByCourseId(cid);
		return list; 
	}
	
	@PostMapping("/student/course/{sid}/{cid}")
	public StudentCourse enrollStudentInCourse(@PathVariable("sid") Long sid,
				 					  @PathVariable("cid") Long cid) {
		/* Step 1- check if student ID exists and fetch student record */
		Student student = studentRepository.fetchStudentRecord(sid);
		if(student == null)
			throw new RuntimeException("Student ID Invalid");
		
		/* Step 2- check if course ID exists and fetch course record */
		Course course=courseRepository.fetchCourseRecord(cid);
		if(course == null)
			throw new RuntimeException("Course ID Invalid");
		
		/* Step 3- Create StudentCourse object and attach student and course to it */
		StudentCourse sc = new StudentCourse();
		sc.setStudent(student);
		sc.setCourse(course);
		sc.setEnroll_date(LocalDate.now());
		
		/* Step 4- save StudentCourse object*/
		return studentCourseRepository.save(sc);
	}
}
