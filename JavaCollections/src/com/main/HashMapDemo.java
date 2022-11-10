package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		//map takes <key,value>	
		map.put("harry", "potter");
		map.put("ronald", "weasley");
		map.put("hermione", "granger");	
		System.out.println(map);
		
		System.out.println("****ALL KEYS*******");
		for(String key : map.keySet()) { //key =harry, key=ronald, key=hermione
			System.out.print(key + " ");
		}		
		System.out.println("\n*****ALL VALUES*******");
		for(String value : map.values()) { //value=potter, value=weasley, value=granger
			System.out.print(value + " ");
		}	
		System.out.println("\n********LOGIN***********");
		/* take username from the user and verify if its present in the map.  */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Username");
		String username = sc.next();
		
		if(!map.containsKey(username)) {
			System.out.println("Invalid Username");
			sc.close();
			return; 
		}
		
		System.out.println("Enter the password");
		String password=sc.next();
		
		//given the key(username) fetch the value(password) and compare
		String passMap = map.get(username);
		
		if(!password.equals(passMap)) {
			System.out.println("Invalid password");
			sc.close();
			return;
		}
		
		System.out.println("Login Success, Welcome " + username);
		sc.close();
	}
}
