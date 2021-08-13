package com.example.transfer.exception;

@SuppressWarnings("serial")
public class InvalidAccountDetailsException extends Exception{

	@Override
	public String getMessage() {
		return "Invalid details! please enter valid account details ";
	}
}
