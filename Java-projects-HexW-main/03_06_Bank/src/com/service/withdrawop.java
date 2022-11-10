package com.service;

import com.main.Customer;

public interface withdrawop {
	double limit=50000;
	void withdraw(Customer customer, double amount);
	

}
