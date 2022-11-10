package com.main;

import java.util.Collections;
import java.util.Vector;

public class App {
	public static void main(String[] args) {
		Vector<Double> list = new Vector<>();
		list.add(20D);
		list.add(15d);
		list.add(12D); 
		list.add(25.0);
		
		System.out.println(list);
		System.out.println(list.size()); //4
		
		/* Iteration */
		for(Double d : list) { //
			System.out.print(d + "  ");
		}
		
		/* Sorting: ASC */
		Collections.sort(list);
		System.out.println("\n*****After Sorting *********"); 
		System.out.println(list); //[12.0, 15.0, 20.0, 25.0]
		
		Collections.reverse(list);
		System.out.println(list); //[25.0, 20.0, 15.0, 12.0]
		
		/* binary search */
		Collections.sort(list); ////[12.0, 15.0, 20.0, 25.0]
		int index = Collections.binarySearch(list, 15.0); 
		System.out.println(index); //1
		
		/* refer elements using index */
		double e = list.get(1);
		System.out.println(e);
		
		/* remove element from list*/
		list.remove(20.0);
		System.out.println(list); //[]
		System.out.println(list.size()); //3
		//removeAll() removes all elements from the list 
		
	}
}
