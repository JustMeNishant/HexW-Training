package com.beans;

public class Customer { // C1 C2 C3
	private String name;
	private double balance;
	private static double rateOfInterest;


	public Customer(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getRateOfInterest() {
		return rateOfInterest;
	}

	public static void setRateOfInterest(double rateOfInterest) {
		Customer.rateOfInterest = rateOfInterest;
	}

}
