package com.main.services;

import java.util.ArrayList;

import com.main.beans.Employee;

public class EmployeeService {

	public static ArrayList<Employee> getlist() {
		Employee e1 = new Employee(1, "Harry Potter", 85000, "London");
		Employee e2 = new Employee(2, "Ronald weasely", 75000, "Surrey");
		Employee e3 = new Employee(3, "hermione granger", 95000, "London");
		ArrayList<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		return list;
	}

}
