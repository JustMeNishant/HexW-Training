package com.main;
import java.util.Scanner;
import com.source.srcc;
public class inmarks {
	public static void main(String[] args) 
	{
		srcc res= new srcc();
		for(int i=0;i<3;i++)
		{
	
	System.out.print("Enter Vaules");
	int[] x= new int[3];
	Scanner sc=new Scanner(System.in);  
	for(int j=0; j<3; j++)  
	{  
	//reading array elements from the user   
	x[j]=sc.nextInt();  
	}  
//	int x=sc.nextInt();
//	int y=sc.nextInt();
//	int z=sc.nextInt();
	res.check(x[0], x[1], x[2]);
	res.eval(x[0],x[1],x[2]);
		}
}
}