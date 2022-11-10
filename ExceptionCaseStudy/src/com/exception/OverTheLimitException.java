package com.exception;

public class OverTheLimitException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	private String message; 
	
	public OverTheLimitException(String message) {
		this.message = message; 
	}
	
	public String getMessage(){
		return message; 
	}
}
