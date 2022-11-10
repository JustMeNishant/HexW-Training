package com.main;

import java.util.HashMap;
import java.util.Scanner;

public class App {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String pass;
	    int flag=0;
	        //
	        HashMap<String, String> map = new HashMap<>();
	        HashMap<String, String> search = new HashMap<>();
	       
	        map.put("Nishant", "123456");
	        map.put("Imtiaz", "987654");
	        map.put("Abhay", "543210");
System.out.println("Enter your UserName");
String name=sc.nextLine();
	        if (map.containsKey(name)) {
	        	System.out.println("User Found, Enter Password");
	        	 String p = sc.nextLine();
	        	search.put(name,p);
	        	 boolean matches = search.entrySet().stream().anyMatch(it -> map.entrySet().contains(it));
if(matches==true) {
	             System.out.println("User found, access granted");
	             flag=1;}
else {
	System.out.println("Wrong Password, Access Denied");
}
	      	        }
	        else {
	        	System.out.println("User Not found, access granted");
	        }
	        if(flag==1) {
	        	System.out.println("You Now Have AccessNisa");
	        }
	    }
	

	}