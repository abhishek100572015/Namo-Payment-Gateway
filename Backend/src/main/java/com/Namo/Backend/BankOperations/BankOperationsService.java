package com.Namo.Backend.BankOperations;

import com.Namo.Backend.PaymentModelClasses.BankResponseClass;
import com.Namo.Backend.PaymentModelClasses.Card.CardPaymentInfo;
/**
 * 
 * Contains the methods to communicate with bank
 *
 */
public interface BankOperationsService {

	/**
	 * Allows to do a card transaction with the bank
	 * @param cardPaymentInfo
	 * @return
	 */
	public BankResponseClass doBankTransactionWithCard(CardPaymentInfo cardPaymentInfo);
}
