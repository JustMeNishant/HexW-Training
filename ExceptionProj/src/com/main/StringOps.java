package com.main;

public class StringOps {
	public static void main(String[] args) {
		/* Conversion from String-double/long & vice-versa */
		
		String s1="5";
		double d = Double.parseDouble(s1);
		System.out.println(d);//5.0
		
		//Double to String
		Double d1=10.5; 
		String s2 = d1.toString();
		System.out.println(s2);
		
		double d3=10.5;
		String s3 = Double.toString(d3); 
		System.out.println(s3);
		
		String str= "harry potter"; //10X
		System.out.println("Length is: " + str.length()); //12
		str = str.concat(" hogwards"); //harry potter hogwards : 100X
		System.out.println(str); //harry potter hogwards
		
		String str1="                            jack sparrow                        ";
		System.out.println(str1.length()); 
		
		//trim() gets rid of beginning and trailing whitespace
		str1 = str1.trim();
		System.out.println(str1);//jack sparrow
		System.out.println(str1.length());//12
		
		//split
		String info="harry potter hogwards";
		String[] arr = info.split(" ");
		System.out.println("fname: " + arr[0]);
		System.out.println("lname: " + arr[1]);
		System.out.println("schname: " + arr[2]);
		
		
	}
}
/*
int : Integer
float: Float
long : Long
double : Double

String
*/