package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beans.Employee;
import com.enums.SortDirection;
import com.exception.MarksException;
import com.service.A;

public class ATest {

	private static A a; 
	
	@BeforeClass
	public static void beforeClass() {
		a=new A(); 
	}
	
	/*
	 * @Before public void init() { a=new A(); }
	 */
	
	@Test
	public void sumTest(){
		//Reach out to class A
		int actual = a.sum(4, 3);
		int expected = 7; 
		Assert.assertEquals(expected,actual);
		Assert.assertEquals(-1,a.sum(-4, 3));
		Assert.assertEquals(-7,a.sum(-4, -3));
		Assert.assertEquals(0,a.sum(0, 0));
	}
	
	@Test
	public void computePercentTest() {
		Assert.assertEquals(80, Math.round(a.computePercent(241, 300)));
		Assert.assertEquals(81, Math.round(a.computePercent(242, 300)));
		Assert.assertNotEquals(80, Math.round(a.computePercent(242, 300)));
	}
	
	@Test
	public void computeGradeTest() {
		Assert.assertEquals("A",a.computeGrade(80));
		Assert.assertEquals("B",a.computeGrade(70));
		Assert.assertEquals("C",a.computeGrade(50));
	}
	
	@Test
	public void sortArrayTest() {
		Integer[] arr = new Integer[]{4,3,6,1,7,9,2};
		
		Integer[] arrExpected = new Integer[]{1,2,3,4,6,7,9};
		Assert.assertArrayEquals(arrExpected, a.sortArray(arr, SortDirection.ASC));
	
		arrExpected = new Integer[]{9,7,6,4,3,2,1};
		Assert.assertArrayEquals(arrExpected, a.sortArray(arr, SortDirection.DESC));
	}
	
	@Test
	public void filterEmployeeListTest() {
		Employee e1 = new Employee("harry", "london", 85000);
		Employee e2 = new Employee("ronald", "surrey", 75000);
		Employee e3 = new Employee("hermione", "london", 90000);
		Employee e4 = new Employee("draco", "manchester", 80000);
		Employee e5 = new Employee("neville", "london", 70000);
		Employee e6 = new Employee("dumbledore", "manchester", 125000);
		Employee e7 = new Employee("snape", "surrey", 100000);
		
		/*
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		*/
		List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5,e6,e7);
		List<Employee> filteredList = Arrays.asList(e1,e3,e5);
		Assert.assertEquals(filteredList, a.filterEmployeeList(list, "city", "london"));
		
		filteredList = Arrays.asList(e2,e7);
		Assert.assertEquals(filteredList, a.filterEmployeeList(list, "city", "surrey"));
		filteredList=new ArrayList<>();
		Assert.assertEquals(filteredList, a.filterEmployeeList(list, "city", "liverpool"));
		
		filteredList = Arrays.asList(e1,e3,e4,e6,e7);
		Assert.assertEquals(filteredList, a.filterEmployeeList(list, "salary", "80000"));
		filteredList = Arrays.asList(e3,e6,e7);
		Assert.assertEquals(filteredList, a.filterEmployeeList(list, "salary", "90000"));
		
		filteredList=new ArrayList<>();
		Assert.assertEquals(filteredList, a.filterEmployeeList(list, "id", "10"));
	}
	
	@Test /* (expected = MarksException.class) */
	public void computePercentWithException(){
		try {
			Assert.assertEquals(73, Math.round(a.computePercentWithException(220, 300)));
		}
		catch(MarksException e) { }
		
		try {
			Assert.assertEquals(73, Math.round(a.computePercentWithException(-2, 300)));
		}
		catch(MarksException e) {
			Assert.assertEquals("Marks secured cannot be < 0", e.getMessage());
		}
		
		try {
			Assert.assertEquals(73, Math.round(a.computePercentWithException(350, 300)));
		}
		catch(MarksException e) {
			Assert.assertEquals("Marks secured cannot be > total", e.getMessage());
		}
		
		try {
			Assert.assertEquals(73, Math.round(a.computePercentWithException(0, 0)));
		}
		catch(MarksException e) {
			Assert.assertEquals("Marks total cannot be <= 0", e.getMessage());
		}
	}
	
	/*
	 * @After public void destroy() { a=null; }
	 */
	
	@AfterClass
	public static void afterClass() {
		a=null;
	}
}

 










