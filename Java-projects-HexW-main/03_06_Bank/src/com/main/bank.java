package com.main;

import java.util.Scanner;
import java.util.ArrayList;
import com.service.deposit;
import com.service.withdraw;

public class bank{
	ArrayList<Customer> accounts =new ArrayList<>();
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
		
		Customer c1=new Customer(); 
		c1.setName("Harry Potter\t\t"); 
		c1.setBalance (100000);
		
		Customer c2 = new Customer(); 
		c2.setName("Ronald Weasley\t"); 
		c2.setBalance (80000);
	
		System.out.println("Initial State ");
		System.out.print("1.");
		System.out.print(c1.getName());
		System.out.println(c1.getBalance());
		System.out.print("2.");
		System.out.print(c2.getName());
		System.out.println(c2.getBalance());
		
		deposit depo =new deposit();
		withdraw withd= new withdraw();
		
		System.out.println("Enter money to deposit to Harry's account");
		int m1=sc.nextInt();
		System.out.println("Enter money to deposit to Ronald's's account");
		int m2=sc.nextInt();
		depo.depositsum(c1, m1);
		depo.depositsum(c1, m2);
		System.out.println("After Deposit ");
		System.out.print("1.");
		System.out.print(c1.getName());
		System.out.println(c1.getBalance());
		System.out.print("2.");
		System.out.print(c2.getName());
		System.out.println(c2.getBalance());
		System.out.println("Enter money to withdraw from Harry's account");
		int w1=sc.nextInt();
		System.out.println("Enter money to withdraw from Ronald's's account");
		int w2=sc.nextInt();
		withd.withdrawsum(c1, w1);
		withd.withdrawsum(c2, w2);
		System.out.println("After Withdrawl ");
		System.out.print("1.");
		System.out.print(c1.getName());
		System.out.println(c1.getBalance());
		System.out.print("2.");
		System.out.print(c2.getName());
		System.out.println(c2.getBalance());
	
			
		}
		

	}



	

	