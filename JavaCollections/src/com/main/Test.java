package com.main;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		/* 2 ways of creating an ArrayList */
		ArrayList<Integer> list = new ArrayList<>();  //pure
		
		List<String> list1=new ArrayList<>(); //poly
		
		/* Raw and Generic*/
		List<String> list2=new ArrayList<>(); //Generic implementation
		
		List  list3=new ArrayList(); //Raw type
		list3.add(1);
		list3.add("");
		
		//"" 1  2 3
		
		
	}
}
