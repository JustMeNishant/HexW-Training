package com.mybootapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Student student;

	@OneToOne
	private Course course;

	private LocalDate enroll_date;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(LocalDate enroll_date) {
		this.enroll_date = enroll_date;
	}

}
