package com.Namo.Backend.PaymentLogic;

import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentModelClasses.FinalResponseClass;
import com.Namo.Backend.PaymentModelClasses.Card.CardPaymentInfo;

public interface CardPaymentLogicService {

	public FinalResponseClass initiatePaymentForCard(CardPaymentInfo cardPaymentInfo,String modeOfPayment) throws PaymentExceptions;
	
}
