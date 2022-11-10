package com.main;
public class Customer {
	private static double RateOfInterest;
	public static void setRateOfInterest(double d) {
		RateOfInterest = d;
	}
	private String name;
	private int balance;
	public void setName(String string) {
		this.name = string;
		}

	public void setBalance(double d) {
		this.balance = (int) d;
		// TODO Auto-generated method stub
		
	}

	public int getBalance() {
		// TODO Auto-generated method stub
		
		return this.balance;
	}



	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}



	

}


