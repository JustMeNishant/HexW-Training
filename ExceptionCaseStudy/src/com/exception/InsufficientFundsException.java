package com.exception;

public class InsufficientFundsException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message; 
	
	public InsufficientFundsException(String message) {
		this.message = message;
	}
	
	public String getMessage(){
		return message; 
	}

}
