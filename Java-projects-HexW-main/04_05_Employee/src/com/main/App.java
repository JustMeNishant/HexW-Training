package com.main;
import com.main.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
public class App {
	
		
	public static void main(String args[]) {
		
																																											
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		ArrayList<Employee> employees = new ArrayList<>();
		employee1.setId(1);
		employee1.setName("Harry Potter");
		employee1.setCity("London");
		employee1.setSalary(85000);
		employees.add(employee1);
		
		employee2.setId(2);
		employee2.setName("Ronald Weasley");
		employee2.setCity("Surrey");
		employee2.setSalary(75000);
		employees.add(employee2);
		
		employee3.setId(3);
		employee3.setName("Hermione Granger");
		employee3.setCity("London");
		employee3.setSalary(95000);
		employees.add(employee3);
		System.out.println("initial List:");
		for(Employee e: employees) {
			System.out.println(e);
				}
		System.out.println("Sorted List By Salary  Asc:");
		employees.sort(Comparator.comparingDouble(Employee::getSalary));
		for(Employee e: employees) {
			System.out.println(e);
			}
		System.out.println("Sorted List By Salary  Desc:");
		employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
		for(Employee e: employees) {
			System.out.println(e);
	}
		System.out.println("Employee having Salary >80000");
		for(Employee e: employees) {
			if(e.getSalary()>80000) {
				System.out.println(e);
			}
		}
			System.out.println("Employee staying in London");
			for(Employee e1: employees) {
				if(e1.getCity().equalsIgnoreCase("London")) {
					System.out.println(e1);
				}
			}
		}
}



		


