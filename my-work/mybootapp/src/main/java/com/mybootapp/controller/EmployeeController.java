package com.mybootapp.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Employee;
import com.mybootapp.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:5199/"})
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeerepository;

	@PostMapping("/employee/insert")
	public Employee insertEmployee(@RequestBody Employee employee) {
		return employeerepository.save(employee);
	}
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeerepository.findAll();
		return list;
	}
	
	@GetMapping("/employee/one/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		Optional<Employee> optional = employeerepository.findById(id);
		
		if(!optional.isPresent())
			throw new RuntimeException("Invalid ID");
		Employee e = optional.get();
		return e;
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") Long id) {
		employeerepository.deleteById(id);
	}
	
	@PutMapping("/employee/update/{id}")
	public Employee updateEmployeeById(@PathVariable("id") Long id,@RequestBody Employee newEmployee) {
		
		Optional<Employee> optional = employeerepository.findById(id);
		if (!optional.isPresent())
			throw new RuntimeException("Invalid Id");
		Employee oldEmployee = optional.get();
		oldEmployee.setName(newEmployee.getName());
		oldEmployee.setCity(newEmployee.getCity());
		oldEmployee.setSalary(newEmployee.getSalary());
		
		return employeerepository.save(oldEmployee);
		
	}
}
