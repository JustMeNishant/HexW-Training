package com.service;

import com.beans.Customer;
import com.exception.InsufficientFundsException;
import com.exception.OverTheLimitException;
import com.main.Withdrawal;

public class WithdrawalService implements Withdrawal{

	@Override
	public void withdraw(Customer c, double amount) 
			throws InsufficientFundsException, OverTheLimitException {
		
		if(amount > Withdrawal.limit)
			throw new OverTheLimitException("Cannot withdraw more than" +  Withdrawal.limit + " at a time");
		if(amount > c.getBalance())
			throw new InsufficientFundsException("Amount must be less than balance: no overdraft allowed");
		
		c.setBalance(c.getBalance() - amount);
		
	}

	
}
