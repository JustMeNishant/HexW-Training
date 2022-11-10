package com.main;
import com.main.Customer;
public class B{

	public double interestPayable(Customer c) {
			int s =c.getBalance();
			int sum= (int) ((s*4.5)/100);
			return sum;
			}
	
	
	}
