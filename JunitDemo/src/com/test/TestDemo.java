package com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDemo {

	@BeforeClass
	public static void beforeclass() {
		System.out.println("before class..");
	}
	
	@Before
	public void before() {
		System.out.println("before test..");
	}
	
	@Test
	public void sampleTest1() {
		System.out.println("test 1 called..");
	}
	
	@Test
	public void sampleTest2() {
		System.out.println("test 2 called..");
	}
	
	@After
	public void after() {
		System.out.println("after test..");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("after class..");
	}
}
