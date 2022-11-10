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

	@GetMapping("/student/course/{cid}")
	public List<Student> getStudentByCourseID(@PathVariable("cid") Long cid) {
		
		List<Student> list = studentCourseRepository.getStudentByCourseID(cid);
		return list;
	}
	
	@PostMapping("/student/course/{sid}/{cid}")
	public StudentCourse enrollStudentInCourse(@PathVariable("sid") Long sid,
										@PathVariable("cid") Long cid) {
		
		Student student = studentRepository.findStudentById(sid);
		if(student == null)
			throw new RuntimeException("Invalid Student ID");
		Course course = courseRepository.findCourseById(cid);
		if (course == null)
			throw new RuntimeException("Invalid Course ID");
		
		StudentCourse sc = new StudentCourse();
		sc.setStudent(student);
		sc.setCourse(course);
		sc.setDate(LocalDate.now());
		
		return studentCourseRepository.save(sc);
	}
}
