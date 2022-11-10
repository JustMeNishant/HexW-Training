package com.main.services;


public class College {
	private double m1,m2,m3;
	public College(double m1, double m2, double m3) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	public College() {
		super();
	}
	public void compute() {	
		double marks = (this.m1+this.m2+this.m3);
		System.out.println("Total marks: "+marks);
		System.out.println("Percentage "+marks/3);
	}
}
