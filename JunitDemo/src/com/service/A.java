package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.beans.Employee;
import com.enums.SortDirection;
import com.exception.MarksException;

//service class 
public class A {
	
	//add 2 nos and return the result 
	public int sum(int x, int y){
		return x+y;
	}
	
	//compute the percent based on marks given
	public double computePercent(double marksS, 
			double marksT){
		double percent = (marksS*100) / marksT; 
		return percent; 
	}
	
	//given the percent compute grade 
	public String computeGrade(double percent) {
//		if(percent > 75)
//			return "A"; 
//		if(percent > 60)
//			return "B";
//		return "C";
		
		return percent > 75? "A" : percent>60? "B" : "C";
	}
	
	public Integer[] sortArray(Integer[] arr, SortDirection direction) { //ASC, DESC
		if(direction.toString().equalsIgnoreCase("ASC")) {
			//sort as per ASC order
			Arrays.sort(arr);
		}
		else {
			//sort as per DESC order
			Arrays.sort(arr,Collections.reverseOrder());
		}
		return arr; 
	}
	
	//given the list filter as per city 
	public List<Employee> filterEmployeeList(List<Employee> list, 
			String field, String value) {
		List<Employee> filteredList = new ArrayList<>();
		if(field.equalsIgnoreCase("city")) {
			//filter as per city value
			for(Employee e : list) {
				if(e.getCity().equalsIgnoreCase(value))
					filteredList.add(e);
			}
		}
		else
		if(field.equalsIgnoreCase("salary")) {
			//filter as per salary value
			for(Employee e : list) {
				if(e.getSalary() >= Double.parseDouble(value))
					filteredList.add(e);
			}
		}
		
		return filteredList;
	}
	
	
	//compute percent based on marks and total with exception
	public double computePercentWithException(double marksS, 
			double marksT) throws MarksException{
		if(marksS > marksT) {
			//throw an exception 
			throw new MarksException("Marks secured cannot be > total");
		}
		if(marksS < 0) {
			//throw an exception
			throw new MarksException("Marks secured cannot be < 0");
		}
		if(marksT <= 0) {
			//throw an exception
			throw new MarksException("Marks total cannot be <= 0");
		}
		
		double percent = (marksS*100) / marksT; 
		return percent; 
	}
}

















