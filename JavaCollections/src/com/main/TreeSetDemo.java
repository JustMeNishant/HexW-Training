package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>(); 
		set.add(4);
		set.add(2);
		set.add(3);
		set.add(1);
		//set.add(null); //NullPointerException will be thrown  
		
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(null); //no issues
		System.out.println(list);
		
		list.remove(null);
		System.out.println(list);
		
		Set<Integer> set1 = new TreeSet<>(list); 
		System.out.println(set1); //sorted list
	}
}
