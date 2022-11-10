package com.main;

public class SBDemo {
	public static void main(String[] args) {
		StringBuilder sb1=new StringBuilder("harry"); //100X
		//StringBuilder sb2 = "harry potter"; -- Cannot create literals for StringBuilder class
		StringBuilder sb2=new StringBuilder("harry"); //200X
		StringBuilder sb3=new StringBuilder("harry"); //200X
		System.out.println(sb1.equals(sb2)); //false 100X.equals(200X)
		System.out.println(sb1 == sb2); //false 100X == 200X 
		
		sb1.append(" potter"); //harry potter
		System.out.println(sb1);//harry potter
		
		// name=john 
		StringBuilder sb4=new StringBuilder("john");
		System.out.println(sb4.reverse());
		
		//conversion: StringBuilder to String
		System.out.println(sb3.toString().equals(sb2.toString())); //true
		
		//String to StringBuilder 
		String name="john squire";
		StringBuilder sbName = new StringBuilder(name.toUpperCase());
		 
		
	}
}
