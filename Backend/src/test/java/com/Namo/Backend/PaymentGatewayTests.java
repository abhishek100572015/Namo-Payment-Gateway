package com.Namo.Backend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import com.Namo.Backend.Entities.TransactionDetails;
import com.Namo.Backend.PaymentLogic.CardPaymentLogic;
import com.Namo.Backend.PaymentModelClasses.FinalResponseClass;
import com.Namo.Backend.PaymentModelClasses.Card.CardPaymentInfo;
import com.Namo.Backend.Repositories.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class PaymentGatewayTests {

	 @InjectMocks
	 CardPaymentLogic cardPaymentLogic;

	 @Mock
	PaymentRepository paymentRepository;
	 
	    @Before
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }

	
	@Test
	public void testCreditCardWholeFlow() throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		CardPaymentInfo cardPaymentInfo = mapper.readValue(PaymentGatewayTestsConstants.VALID_REQUEST_CREDITCARD, CardPaymentInfo.class); 
		System.out.println(paymentRepository);
		Mockito.when(paymentRepository.save(Mockito.any(TransactionDetails.class))).thenReturn(null);
		FinalResponseClass finalResponseClass = cardPaymentLogic.initiatePaymentForCard(cardPaymentInfo,"creditcard");
		assertEquals(cardPaymentInfo.getAmount(),finalResponseClass.getAmount());
		assertEquals(cardPaymentInfo.getCurrency(),finalResponseClass.getCurrency());
		assertEquals(cardPaymentInfo.getType(),finalResponseClass.getType());		
	}
	
	@Test
	public void testDebitCardWholeFlow() throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		CardPaymentInfo cardPaymentInfo = mapper.readValue(PaymentGatewayTestsConstants.VALID_REQUEST_DEBITCARD, CardPaymentInfo.class); 
		System.out.println(paymentRepository);
		Mockito.when(paymentRepository.save(Mockito.any(TransactionDetails.class))).thenReturn(null);
		FinalResponseClass finalResponseClass = cardPaymentLogic.initiatePaymentForCard(cardPaymentInfo,"creditcard");
		assertEquals(cardPaymentInfo.getAmount(),finalResponseClass.getAmount());
		assertEquals(cardPaymentInfo.getCurrency(),finalResponseClass.getCurrency());
		assertEquals(cardPaymentInfo.getType(),finalResponseClass.getType());		
	}

}
