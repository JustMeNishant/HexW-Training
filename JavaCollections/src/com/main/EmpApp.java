package com.main;
import java.util.ArrayList;
import com.beans.Employee;
import com.service.EmployeeService;
public class EmpApp {
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();
		ArrayList<Employee> list = service.getEmployeeList();
		
		for(Employee e : list) { //e=e1, e=e2, e=e3
			System.out.println(e);
		}
		
		//filteration of list 
		ArrayList<Employee> filteredlist = new ArrayList<>();
		System.out.println("****Filtered List (salary>80000)**** ");
		/* Filter the list that has salary > 80000 */
		for(Employee e : list) { //e=e1, e=e2, e=e3
			if( e.getSalary() > 80000) {
				//list.remove(e); -- ConcurrentModificationException
				filteredlist.add(e);
			}
		}
		
		for(Employee e : filteredlist) { //e=e1, e=e2, e=e3
			System.out.println(e);
		}
		
		filteredlist.clear();
		System.out.println("****Filtered List (city=surrey)**** ");
		for(Employee e : list) {
			if(e.getCity().equalsIgnoreCase("surrey"))
				filteredlist.add(e);
		}
		for(Employee e : filteredlist) { //e=e1, e=e2, e=e3
			System.out.println(e);
		}
		
	}
}
