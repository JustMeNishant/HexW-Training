package com.main;

import com.beans.Customer;

public interface BankOperations {
	void deposit(Customer c, double amount);
	void withdraw(Customer c, double amount);
	double interestPayable(Customer c);
}
