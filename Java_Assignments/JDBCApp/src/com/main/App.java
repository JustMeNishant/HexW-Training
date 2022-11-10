package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beans.Employee;
import com.services.EmployeeService;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeService employeeservice = new EmployeeService();
		List<Employee> employeelist = new ArrayList<>();
		

		boolean flag = true;
		
		while(flag) {
		System.out.println("======Employee Services=====");
		System.out.println("1.Insert Employee record");
		System.out.println("2.Display all the records");
		System.out.println("3.Delete a record");
		System.out.println("4.Exit");
		int n=sc.nextInt();
		
		switch(n) {
		
		case(1):
			System.out.println("Enter employee details");
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter salary");
			double salary = sc.nextDouble();
			System.out.println("Enter city");
			String city = sc.next();
			employee.setName(name);
			employee.setSalary(salary);
			employee.setCity(city);
			employeeservice.insert(employee);
			System.out.println("Employee inserted sucessfully");
			break;
			
		case(2):
			System.out.println("====Employees records====");
		employeelist = employeeservice.fetchEmployees();
			for (Employee e: employeelist) {
				System.out.println(e);
			}
			break;
		case(3):
			System.out.println("Enter the id to delete record");
		    int id = sc.nextInt();
		    employeeservice.deleteEmployee(id);
		    System.out.println("Employee deleted succefully");
		    break;
		case(4):
			flag = false;
			break;
		}
		}
		sc.close();
	}

}
