package com.mybootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.dto.StudentDto;
import com.mybootapp.model.Address;
import com.mybootapp.model.Student;
import com.mybootapp.repository.AddressRepository;
import com.mybootapp.repository.StudentRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4201"})
public class StudentController {
	@Autowired
	private StudentRepository studentRepository; 
	@Autowired
	private AddressRepository addressRepository; 
	/*
	 {
	"name":"harry potter",
	"email":"harry@gmail.com",
	"address": {
	  		"hno": 12,
	  		"pincode":"TW31SE",
	  		"city":"london"
		}
	}
	 */
	@PostMapping("/student/insert")
	public Student insertStudent(@RequestBody Student student) {
		System.out.println(student.getName()); //harry potter
		System.out.println(student.getEmail());//harry@gmail.com
		System.out.println(student.getAddress());//Address [id=null, hno=12, pincode=TW31SE, city=london]
		
		/* Save Address in DB */
		Address address = addressRepository.save(student.getAddress()); 
		//Address [id=5, hno=12, pincode=TW31SE, city=london] 
		
		/* attach address with id to student */
		student.setAddress(address);
		
		System.out.println(student);
		// Student [id=null, name=harry potter, email=harry@gmail.com, address=Address [id=7, hno=12, pincode=TW31SE, city=london]]

		return studentRepository.save(student);
	}
	/*
	 {
	"name":"harry potter",
	"email":"harry@gmail.com",
	"hno": 12,
	"pincode":"TW31SE",
	"city":"london"
	 }
	 */
	@PostMapping("/student/post")
	public Student postStudent(@RequestBody StudentDto studentDto) {
		System.out.println(studentDto);
		//StudentDto [name=harry potter, email=harry@gmail.com, hno=12, pincode=TW31SE, city=london]
		
		/* Attach dto values to student and address objects */
		Student student = new Student(); 
		student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		
		Address address=new Address();
		address.setHno(studentDto.getHno());
		address.setCity(studentDto.getCity());
		address.setPincode(studentDto.getPincode());
		
		/* Save address in DB and let hibernate generate ID.  */
		Address addressDB = addressRepository.save(address); 
	
		/*Attach addressDB to student */
		student.setAddress(addressDB);
		
		/* save the student and return the response */
		return studentRepository.save(student);
	}
	/*
	 * Display students on the basis of city. 
	 */
	@GetMapping("/student/city/{city}")
	public List<Student> getStudentByCity(@PathVariable("city") String city) {
		List<Student> list = studentRepository.getStudentByCity(city);
		return list; 
	}
	//Activate pagination
	@GetMapping("/student/all")
	public List<Student> getAllStudents(
			@RequestParam(name =  "page", required = false, defaultValue = "0") Integer page, 
			@RequestParam(name="size", required = false, defaultValue = "10") Integer size) {
		
		/* PageRequest does the pagination setting on the basis of page and size, 
		  We save the setting in pageable ref.  
		  
		  http://localhost:8181/student/all?page=1&size=2
		  */
		
		Pageable pageable = PageRequest.of(page, size); 
		Page<Student> pageData = studentRepository.findAll(pageable);
		return pageData.getContent(); 
	}
}
