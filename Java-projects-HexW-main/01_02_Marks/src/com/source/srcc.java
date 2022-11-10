package com.source;

public class srcc {

	private static final char A = 0;
	private static final char B = 0;
	private static final char C = 0;

	public void eval(int x, int y, int z) {
		int s;
		int p;
		String g;
		s= sum(x,y,z);
		p=percentage(s);
		g=grade(p);
		System.out.println("Sum="+ s + " Percentage="+p+" Grade="+g );
	}

	private String grade(int p) {

		// TODO Auto-generated method stub
		if(p>75)
			return  "A";
		if(p>65)
			return "B";
		else
			return  "C";
	}

	private int percentage(int s) {
		// TODO Auto-generated method stub
		return s/3;
	}

	private int sum(int x, int y, int z) {
		// TODO Auto-generated method stub
		int res=x+y+z;
		return res;
	}

	public void check(int i, int j, int k)throws   RuntimeException {
	
		if ((i> 100) || (i<0)) {
				throw new RuntimeException("Marks of subjet 1 must be between 1 and 100");
				 
				 }
		if ((j> 100) || (j<0)) {
			throw new RuntimeException("Marks of subjet 2 must be between 1 and 100");
			
			}
		if ((k> 100) | (k<0)) {
			throw new RuntimeException("Marks of subjet 3 must be between 1 and 100");	
		}
	
	}
		// TODO Auto-generated method stub

	

}
