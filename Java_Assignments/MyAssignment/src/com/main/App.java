package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,String> map = new HashMap<>();
		map.put("Harry", "magic");
		
		System.out.println("Enter username");
		String username= sc.next();
		if (!map.containsKey(username)) {
			System.out.println("Invalid user");
		}
		String password = sc.next();
		if(map.containsValue(password)) {
			if (password.equals(map.get(username))) {
				System.out.println("Login successful");
			}
		}
		else {
			System.out.println("Invalid Password");
		}
	}

}
