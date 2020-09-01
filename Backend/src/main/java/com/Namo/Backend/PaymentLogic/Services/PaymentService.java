package com.Namo.Backend.PaymentLogic.Services;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentModelClasses.FinalResponseClass;

@Component
public interface PaymentService {
	
	public FinalResponseClass selectPaymentMethod(HashMap<String, Object> paymentInfoMap) throws PaymentExceptions;

}
