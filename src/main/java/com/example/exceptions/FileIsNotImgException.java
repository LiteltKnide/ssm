package com.example.exceptions;

public class FileIsNotImgException extends RuntimeException{
	public FileIsNotImgException(String msg){
		super(msg);
	}
}
