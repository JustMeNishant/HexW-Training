package com.services;

import java.util.List;

import com.beans.Employee;
import com.db.EmployeeDB;

public class EmployeeService {
	EmployeeDB employeeDb = new EmployeeDB();
	public void insert(Employee employee) {
		employeeDb.insert(employee);
	}

	public List<Employee> fetchEmployees() {
		return employeeDb.fetch();
	}

	public void deleteEmployee(int id) {
		employeeDb.deleteEmployee(id);
		
	}


}
