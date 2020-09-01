package com.Namo.Backend.BankOperations;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Namo.Backend.Constants.PaymentConstants;
import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentModelClasses.BankResponseClass;
import com.Namo.Backend.PaymentModelClasses.Card.CardPaymentInfo;

@Component
public class BankSupportedMethods implements BankOperationsService{
/**
 * Helps to do a card transaction with bank and generates timeout if time exceeds 15 secs.
 */
	@Override
	public BankResponseClass doBankTransactionWithCard(CardPaymentInfo cardPaymentInfo) {
		
		String uri = PaymentConstants.URI_FOR_BANK_PAYMENT;
		try {
		RestTemplate restTemplate =  new RestTemplateBuilder()
		        .setConnectTimeout(Duration.ofMillis(15000))
		        .setReadTimeout(Duration.ofMillis(15000))
		        .build();
		return restTemplate.postForObject(uri, cardPaymentInfo, BankResponseClass.class);
		}
		catch(Exception exception) {
			throw new PaymentExceptions("Please try Again!! We cant reach the banks");
		}

	}

}
