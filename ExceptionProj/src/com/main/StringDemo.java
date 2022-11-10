package com.main;

public class StringDemo {
	public static void main(String[] args) {
		String s1="harry"; //String Literal -- goes in the pool 
		String s2 = new String("harry"); //String Object
		
		String s3="harry";
		String s4=new String("harry");
		
		/* String comparisions - equals() , == operator*/
		
		System.out.println(s1.equals(s2)); //true
		
		String s5="Harry";
		System.out.println(s1.equals(s5)); //false
		System.out.println(s1.equalsIgnoreCase(s5)); //true
		
		System.out.println(s1 == s2); //10X == 100X : false
		System.out.println(s1 == s3); //10X == 10X : true
		
		String s6 = s2; 
		System.out.println(s6 == s2); //true
		
		String s7=null;
		if( !(s7 == null) )
			System.out.println(s7.equals(s1));
		
		s1="potter";
		System.out.println(s1); //potter
		System.out.println(s1 == s3); //20X == 10X : false
		 
		s2 = "potter";
		System.out.println(s2); //potter
		System.out.println(s6); //harry
		System.out.println(s6 == s2); //false
	}
}
