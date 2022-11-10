package com.main.exceptions;

public class OverTheLimitException extends Exception{
	String msg;
	public OverTheLimitException(String msg){
		this.msg = msg;
	}
	public String getMessage(){
		return this.msg;
	}
	
}
