package com.main;

import com.main.beans.Customer;
import com.main.exceptions.InsufficientFundsException;
import com.main.exceptions.OverTheLimitException;

public interface WithDraw {
	double limit = 50000;
	void withdraw(Customer customer,double balance) throws InsufficientFundsException
																,OverTheLimitException;
}
