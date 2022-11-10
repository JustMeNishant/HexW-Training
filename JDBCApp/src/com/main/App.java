package com.main;

import java.util.List;
import java.util.Scanner;

import com.beans.Employee;
import com.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		EmployeeService employeeService = new EmployeeService();
		
		System.out.println("*****JDBC******");
		System.out.println("1. Insert Employee");
		System.out.println("2. Display all employee");
		System.out.println("3. Delete the employee");
		
		int input = sc.nextInt(); //users input
		
		switch(input) {
		case 1: 
			System.out.println("Enter Employee Details");
			System.out.println("Employee Name: ");
			String name = sc.next();
			System.out.println("Employee City: ");
			String city = sc.next();
			System.out.println("Employee salary: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee();
			employee.setName(name);
			employee.setCity(city);
			employee.setSalary(salary);
			
			employeeService.insert(employee);
			System.out.println("Employee Record Inserted.. ");
			break;
		case 2: 
			System.out.println("******Display all employees******");
			List<Employee> list = employeeService.fetchEmployees();
			for(Employee e : list) {
				System.out.println(e);
			}
			break;
		case 3: 
			System.out.println("******Delete Employee********");
			System.out.println("Enter the ID of employee to delete");
			int id = sc.nextInt();
			employeeService.deleteEmployee(id);
			System.out.println("Employee record deleted...");
			break;
		}
		
	}
}
