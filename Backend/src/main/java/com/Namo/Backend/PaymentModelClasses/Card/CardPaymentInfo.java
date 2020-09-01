package com.Namo.Backend.PaymentModelClasses.Card;

import com.Namo.Backend.PaymentModelClasses.PaymentInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardPaymentInfo extends PaymentInfo{
	
	public CardPaymentInfo() {
		
	}

	@JsonProperty("card")
	private CardDetails cardDetails;

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	

	
}
