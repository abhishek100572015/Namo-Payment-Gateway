package com.Namo.Backend.Exceptions;

public class PaymentExceptions extends RuntimeException{
	
	String message;

	public PaymentExceptions(String message) {
		super(message);
		this.message = message;
	}
	
}
