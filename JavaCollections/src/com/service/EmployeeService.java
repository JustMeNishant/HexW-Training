package com.service;

import java.util.ArrayList;

import com.beans.Employee;

public class EmployeeService {

	public ArrayList<Employee> getEmployeeList() {
		Employee e1 = new Employee(1,"harry",85000,"london"); //100X
		Employee e2 = new Employee(2,"ronald",75000,"surrey"); //200X
		Employee e3 = new Employee(3,"hermione",90000,"london"); //300X
		
		ArrayList<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		return list;
	}
	
}
