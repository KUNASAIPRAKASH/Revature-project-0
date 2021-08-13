package com.example.transfer.exception;

@SuppressWarnings("serial")
public class InsufficientAmountException extends Exception {

	@Override
	public String getMessage() {
		return "Insuffient amount to debit";
	}
	
}
