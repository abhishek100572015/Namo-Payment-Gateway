package com.Namo.Backend.PaymentLogic;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Namo.Backend.Constants.PaymentConstants;
import com.Namo.Backend.Exceptions.PaymentExceptionConstants;
import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentLogic.Services.PaymentService;
import com.Namo.Backend.PaymentModelClasses.FinalResponseClass;
import com.Namo.Backend.PaymentModelClasses.Card.CardPaymentInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PaymentLogic implements PaymentService{
	
	@Autowired
	CardPaymentLogic cardPaymentLogic;
	/**
	 * recognizes the appropriate payment method and initiates the payment
	 */
	@Override
	public FinalResponseClass selectPaymentMethod(HashMap<String, Object> paymentInfoMap) throws PaymentExceptions {
		
		ObjectMapper mapper = new ObjectMapper();
		String modeOfPayment = "";
		
		if(paymentInfoMap.get(PaymentConstants.PARAMETER_FOR_TYPE) != null) {
			 modeOfPayment = paymentInfoMap.get(PaymentConstants.PARAMETER_FOR_TYPE).toString();
		}
		
		switch(modeOfPayment) {
		
		case(PaymentConstants.PAYMENT_MODE_CREDITCARD):
		case(PaymentConstants.PAYMENT_MODE_DEBITCARD):
			
			CardPaymentInfo cardPaymentInfo = mapper.convertValue(paymentInfoMap, CardPaymentInfo.class);
			return cardPaymentLogic.initiatePaymentForCard(cardPaymentInfo,modeOfPayment);
			
		default:
		
		}
		throw new PaymentExceptions(PaymentExceptionConstants.PAYMENT_METHOD_NOT_SUPPORTED);
	}


	
}
