package com.main.services;

import com.main.WithDraw;
import com.main.beans.Customer;
import com.main.exceptions.InsufficientFundsException;
import com.main.exceptions.OverTheLimitException;

public class WithDrawService implements WithDraw{

	@Override
	public void withdraw(Customer customer, double amount) throws InsufficientFundsException, OverTheLimitException {
		if (amount > WithDraw.limit){
			throw new OverTheLimitException("Limit 50000 exceded");
		}
		else if (amount > customer.getBalance()) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		else
		customer.setBalance(customer.getBalance()-amount);
	}

}
