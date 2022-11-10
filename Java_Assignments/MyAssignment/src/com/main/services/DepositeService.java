package com.main.services;

import com.main.Deposite;
import com.main.beans.Customer;

public class DepositeService implements Deposite{

	@Override
	public void deposite(Customer customer, double balance) {
		customer.setBalance(customer.getBalance()+balance);
	}

}
