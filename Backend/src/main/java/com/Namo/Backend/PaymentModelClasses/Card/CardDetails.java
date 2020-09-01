package com.Namo.Backend.PaymentModelClasses.Card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Stores all the card details
 * @author Abhishek
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDetails {

	public CardDetails() {
	
	}


	private String number;
	private String expirationMonth;
	private String expirationYear;
	private String cvv;
	
	public String getNumber() {
		return number;
	}
	public String getExpirationMonth() {
		return expirationMonth;
	}
	public String getExpirationYear() {
		return expirationYear;
	}
	public String getCvv() {
		return cvv;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
	public CardDetails(String number, String expirationMonth, String expirationYear, String cvv) {
		super();
		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
	}
	
	
	

}
