package com.example.exceptions;

public class UsernameAlreadyExistException extends RuntimeException {
	
	public UsernameAlreadyExistException(String msg){
		super(msg);
	}
}
