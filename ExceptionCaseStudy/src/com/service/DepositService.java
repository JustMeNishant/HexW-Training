package com.service;

import com.beans.Customer;
import com.main.Deposit;

public class DepositService implements Deposit {

	@Override
	public void deposit(Customer c, double amount) {
		c.setBalance(c.getBalance()+amount);
	}

}
