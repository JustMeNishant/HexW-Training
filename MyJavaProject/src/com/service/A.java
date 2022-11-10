package com.service;

import com.beans.Customer;
import com.main.BankOperations;

public abstract class A implements BankOperations {

	@Override
	public void deposit(Customer c, double amount) {
		 c.setBalance(c.getBalance() + amount);
	}
}


