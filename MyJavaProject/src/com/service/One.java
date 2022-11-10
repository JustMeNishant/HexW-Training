package com.service;

public abstract class One extends Geometry{
	//One has to override: areaOfCircle, areaOfRectangle, circumOfCircle
	
	public double areaOfCircle(double radius) {
		return 2 * pi * (radius * radius); 
	}
}
