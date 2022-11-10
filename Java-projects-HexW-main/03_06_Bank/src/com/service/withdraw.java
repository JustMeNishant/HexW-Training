package com.service;

import com.main.Customer;

public class withdraw {
	public void withdrawsum(Customer c1, int i)throws   RuntimeException {
		// TODO Auto-generated method stub
		int s= c1.getBalance();
		if(i>s) {
			throw new RuntimeException("Insufficient fund for withdrawl");
		}
		if(i>5000) {
			throw new RuntimeException("Over the Limit of Withdrawl");
		}
		if(s>i) {
			c1.setBalance(s-i);
	}
}
}
