package com.service;

import com.beans.Customer;

public class CustomerService {

	public void deposit(Customer c, int amount) {
		c.setBalance(c.getBalance() + amount); 	
	}

}
