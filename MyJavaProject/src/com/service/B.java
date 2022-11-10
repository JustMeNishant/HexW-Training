package com.service;

import com.beans.Customer;

public class B extends A{

	@Override
	public void withdraw(Customer c, double amount) {
		 c.setBalance(c.getBalance()-amount);
	}

	@Override
	public double interestPayable(Customer c) {
		return (c.getBalance() * Customer.getRateOfInterest()) / 100;
	}

}
