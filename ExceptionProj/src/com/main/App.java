package com.main;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		 Integer[] arr = new Integer[] {5,3,1,6,7,4,2};
		 
		 /* Compute the length of the array */
		 System.out.println(arr.length);//7
		 
		 /* Iterate over the array  */
		 for(int i=0;i<arr.length;i++) { //i=0,1,2,3,4,5,6
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println("\n");
		 //for-each loop
		 for(int temp :arr) { //
			 System.out.print(temp + " ");
		 }
		 
		 /* Sorting the array */
		 Arrays.sort(arr);
		 System.out.println("\n After sorting");
		 for(int temp :arr) { //
			 System.out.print(temp + " ");
		 }
		 System.out.println("\n");
		 /* Searching the array: binary search */
		 int index = Arrays.binarySearch(arr, 4);
		 System.out.println(index); //3
		 
		 index = Arrays.binarySearch(arr, 10); //-insertion point - 1 = -8
		 System.out.println(index); //-8
	}
}

 