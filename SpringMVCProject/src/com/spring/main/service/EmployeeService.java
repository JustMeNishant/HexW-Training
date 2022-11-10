package com.spring.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.db.EmployeeDB;
import com.spring.main.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDB employeeDB;
	
	public List<Employee> fetchAllEmployees() {
		 //Reach out to EmployeeDB and fetch all employees
		List<Employee> list =  employeeDB.fetchAllEmployees();
		
		return list;
	}

	public void insertEmployee(Employee employee) {
		employeeDB.insertEmployee(employee);
	}

	public void deleteEmployeeById(int id) {
		employeeDB.deleteEmployeeById(id);
		
	}

	public void processEdit(Employee employee) {
		employeeDB.processEdit(employee);
		
	}

}
