package com.beans;

public class Customer {
	private String name;
	private double balance;

	public Customer() {
		super();
	}

	public Customer(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
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

	@Override
	public String toString() {
		return "Customer [name=" + name + ", balance=" + balance + "]";
	}

	
}
