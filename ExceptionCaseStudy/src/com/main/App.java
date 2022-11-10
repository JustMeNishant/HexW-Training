package com.main;

import com.beans.Customer;
import com.exception.InsufficientFundsException;
import com.exception.OverTheLimitException;
import com.service.DepositService;
import com.service.WithdrawalService;

public class App {
	public static void main(String[] args) {
		Customer c1 = new Customer("harry potter",10000);
		Customer c2 = new Customer("hermione granger",12000);
		
		DepositService depositService = new DepositService();
		depositService.deposit(c1, 4000);
		depositService.deposit(c2, 3000);
		depositService.deposit(c1, 50000);
		System.out.println("*******After Deposit*********");
		System.out.println(c1);
		System.out.println(c2);
		
		WithdrawalService withdrawalService = new WithdrawalService();
		try {
			withdrawalService.withdraw(c1, 51000);
		} 
		catch (InsufficientFundsException e) { 
			System.out.println(e.getMessage());
		} 
		catch (OverTheLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*******After Withdrawal*********");
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println("thank you");
	}
}
