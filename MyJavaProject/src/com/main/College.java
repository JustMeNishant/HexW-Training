package com.main;

public enum College {
	ABC(85),PQR(80),XYZ(75);
	
	int marks; 
	
	College(int marks){
		this.marks = marks;
	}

	public int getMarks() {
		return marks;
	}

}
