package com.Namo.Backend;

public class PaymentGatewayTestsConstants {
	
	public static final String REQUEST_WITH_NO_AMOUNT = "{\r\n" + 
			"\"currency\": \"USD\",\r\n" + 
			"\"type\": \"creditcard\",\r\n" + 
			"\"card\": {\r\n" + 
			"\"number\": \"4111111111111111\",\r\n" + 
			"\"expirationMonth\": \"2\",\r\n" + 
			"\"expirationYear\": \"2020\",\r\n" + 
			"\"cvv\": \"111\"\r\n" + 
			"}\r\n" + 
			"}\r\n" ;
	
	public static final String REQUEST_WITH_INVALID_TYPE = "{\r\n" + 
			"\"amount\": \"100\",\r\n" + 
			"\"currency\": \"USD\",\r\n" + 
			"\"type\": \"notpresent\",\r\n" + 
			"\"card\": {\r\n" + 
			"\"number\": \"4111111111111111\",\r\n" + 
			"\"expirationMonth\": \"2\",\r\n" + 
			"\"expirationYear\": \"2020\",\r\n" + 
			"\"cvv\": \"111\"\r\n" + 
			"}\r\n" + 
			"}\r\n" + 
			"";
	
	public static final String VALID_REQUEST_CREDITCARD = "{\r\n" + 
			"\"amount\": \"100\",\r\n" + 
			"\"currency\": \"USD\",\r\n" + 
			"\"type\": \"creditcard\",\r\n" + 
			"\"card\": {\r\n" + 
			"\"number\": \"4111111111111111\",\r\n" + 
			"\"expirationMonth\": \"12\",\r\n" + 
			"\"expirationYear\": \"2020\",\r\n" + 
			"\"cvv\": \"111\"\r\n" + 
			"}\r\n" + 
			"}\r\n" + 
			"";
	
	public static final String VALID_REQUEST_DEBITCARD = "{\r\n" + 
			"\"amount\": \"100\",\r\n" + 
			"\"currency\": \"USD\",\r\n" + 
			"\"type\": \"creditcard\",\r\n" + 
			"\"card\": {\r\n" + 
			"\"number\": \"4111111111111111\",\r\n" + 
			"\"expirationMonth\": \"12\",\r\n" + 
			"\"expirationYear\": \"2020\",\r\n" + 
			"\"cvv\": \"111\"\r\n" + 
			"}\r\n" + 
			"}\r\n" + 
			"";
	

	public static final String EXPIRED_CARD = "{\r\n" + 
			"\"amount\": \"100\",\r\n" + 
			"\"currency\": \"USD\",\r\n" + 
			"\"type\": \"creditcard\",\r\n" + 
			"\"card\": {\r\n" + 
			"\"number\": \"4111111111111111\",\r\n" + 
			"\"expirationMonth\": \"2\",\r\n" + 
			"\"expirationYear\": \"2010\",\r\n" + 
			"\"cvv\": \"111\"\r\n" + 
			"}\r\n" + 
			"}\r\n" + 
			"";

}
