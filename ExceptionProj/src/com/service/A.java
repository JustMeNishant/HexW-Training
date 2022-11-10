package com.service;

public class A {

	public double computeDivision(int i, int j) {
		ArithmeticException e = new ArithmeticException();
		if(j==0 )
			throw e; 
		return i/j;
	}

	public int computeLength(String name) 
			throws NullPointerException,RuntimeException{
		if(name == null)
			throw new NullPointerException("name cannot be null"); 
		if(name.equals(""))
			throw new RuntimeException("Name cannot be blank");
		return name.length();
	}

}
