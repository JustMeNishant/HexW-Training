package com.main;

import com.beans.Customer;
import com.exception.InsufficientFundsException;
import com.exception.OverTheLimitException;

public interface Withdrawal {
	double limit=50000; //final and static
	void withdraw(Customer c, double amount) 
			throws InsufficientFundsException, OverTheLimitException;
}
