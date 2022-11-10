package com.service;

import java.util.List;

import com.beans.Employee;
import com.db.EmployeeDB;

public class EmployeeService {
	EmployeeDB employeeDB = new EmployeeDB();
	
	public void insert(Employee employee) {
		
		employeeDB.insert(employee);
		
	}

	public List<Employee> fetchEmployees() {
		
		return employeeDB.fetchEmployees();
	}

	public void deleteEmployee(int id) {
		employeeDB.deleteEmployee(id);
		
	}

}
