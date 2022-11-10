package com.service;

import com.main.Customer;

public class deposit {
	public void depositsum(Customer c1, int i) {
		Customer c;
		// TODO Auto-generated method stub
		int s=  c1.getBalance();

		c1.setBalance((s+i));
}
}
