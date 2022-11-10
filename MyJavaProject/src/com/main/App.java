package com.main;

import com.beans.Customer;
import com.service.B;

public class App {
	public static void main(String[] args) {
		Customer c1=new Customer("harry potter",10000); 
		
		Customer c2 = new Customer(); 
		c2.setName("");
		c2.setBalance(8000);
		
		Customer.setRateOfInterest(4.5);
		
		B b=new B();
		b.deposit(c1, 2000);
		b.deposit(c2, 3000);
		
		b.withdraw(c1, 500);
		b.withdraw(c2, 1000);
		
		System.out.println(c1.getBalance()); //11500
		System.out.println(c2.getBalance()); //10000
		
		System.out.println("Interest payable to C1/ annum " + b.interestPayable(c1));
		System.out.println("Interest payable to C2/ annum " + b.interestPayable(c2));

	}
}

 