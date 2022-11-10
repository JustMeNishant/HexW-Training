package com.service;

public class Three extends Two{
	
	public double circumOfCircle(double radius){
		return m1(radius);  
	}
	private double m1(double radius) { 
		return 2 * pi * radius;
	}
}
