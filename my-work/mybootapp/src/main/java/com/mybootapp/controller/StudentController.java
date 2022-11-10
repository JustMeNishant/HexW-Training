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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.dto.StudentDto;
import com.mybootapp.model.Address;
import com.mybootapp.model.Student;
import com.mybootapp.repository.AddressRepository;
import com.mybootapp.repository.StudentRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:5199/"})
public class StudentController {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired 
	private StudentRepository studentRepository;


	@PostMapping("/student/insert")
	public Student insertStudent(@RequestBody Student student) {
		
		//getting address
		Address address = student.getAddress();
		
		//adding address to db to get id
		address = addressRepository.save(address);
		
		//adding address to student with id
		student.setAddress(address);
		
		//adding student to db with address with id
		return studentRepository.save(student);
		
	}
	
	@PostMapping("/student/post")
	public Student postStudent(@RequestBody StudentDto studentDto) {
		Student student = new Student();
		Address address = new Address();
		
		student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		address.setHno(studentDto.getHno());
		address.setCity(studentDto.getCity());
		address.setPincode(studentDto.getPincode());
		
		address = addressRepository.save(address);
		
		student.setAddress(address);
		
		return studentRepository.save(student);
	}
	
	@GetMapping("/student/all")
	public List<Student> fetchAllStudents(@RequestParam(name ="page",required=false,defaultValue="0") Integer page,
									@RequestParam(name="size",required=false,defaultValue="10") Integer size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Student> pageData = studentRepository.findAll(pageable);
		return pageData.getContent();
 	}

	
}
