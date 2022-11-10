package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.beans.Employee;
import com.service.EmployeeService;

 
public class EmpSortAPp {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		ArrayList<Employee> list = service.getEmployeeList();
		
		/* Sort the list as per salary ASC  */
		SortAssistAsc sortAssistAsc = new SortAssistAsc();
		Collections.sort(list,sortAssistAsc );
		
		System.out.println("********Sorting ASC**********");
		for(Employee e : list) {
			System.out.println(e);
		}
		
		System.out.println("********Sorting Desc**********");
		/* Sort the list as per salary DESC  */
		SortAssistDesc sortAssistDesc = new SortAssistDesc();
		Collections.sort(list,sortAssistDesc );
		
		for(Employee e : list) {
			System.out.println(e);
		}
	}
}
//e1(80000) , e2(75000)   2 4 =>  
class SortAssistAsc implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getSalary() > e2.getSalary()) {
			//swap 
			return 1; 
		}
		if(e1.getSalary() == e2.getSalary()) {
			//same : don't swap
			return 0; 
		}
		if(e1.getSalary() < e2.getSalary()) {
			//proper ASC order: dont swap
			return -1; 
		}
		
		return 0;
	}
	
}
//2 4 : 
class SortAssistDesc implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getSalary() > e2.getSalary()) {
			//no-swap 
			return -1; 
		}
		if(e1.getSalary() == e2.getSalary()) {
			//same : don't swap
			return 0; 
		}
		if(e1.getSalary() < e2.getSalary()) {
			//swap
			return 1; 
		}
		
		return 0;
	}
	
}
















