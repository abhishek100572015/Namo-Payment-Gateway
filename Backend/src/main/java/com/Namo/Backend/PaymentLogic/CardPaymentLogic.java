package com.Namo.Backend.PaymentLogic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Namo.Backend.BankOperations.BankOperationsService;
import com.Namo.Backend.BankOperations.BankSupportedMethods;
import com.Namo.Backend.Entities.TransactionDetails;
import com.Namo.Backend.Exceptions.PaymentExceptionConstants;
import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentModelClasses.BankResponseClass;
import com.Namo.Backend.PaymentModelClasses.FinalResponseClass;
import com.Namo.Backend.PaymentModelClasses.Card.CardDetails;
import com.Namo.Backend.PaymentModelClasses.Card.CardPaymentInfo;
import com.Namo.Backend.Repositories.PaymentRepository;

@Component
public class CardPaymentLogic implements CardPaymentLogicService{
	
	
	@Autowired
	PaymentRepository paymentRepository;
	
/**
 * Checks about the valid card details and starts the payment for the card
 */
public FinalResponseClass initiatePaymentForCard(CardPaymentInfo cardPaymentInfo,String modeOfPayment) throws PaymentExceptions {
		
		Date date = new java.util.Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		BankOperationsService bankService = new BankSupportedMethods();
		
		CardDetails cardDetails = cardPaymentInfo.getCardDetails();
		
		if(isInputValid(cardPaymentInfo) && areCardDetailsValid(cardDetails)) {	
			
			BankResponseClass bankTransactionResult = bankService.doBankTransactionWithCard(cardPaymentInfo);
			TransactionDetails transactionDetails = generateAndSaveTransactionRecord(cardPaymentInfo,bankTransactionResult,timestamp);
			return generateFinalResponse(transactionDetails);
	
		}
		
		throw new PaymentExceptions(PaymentExceptionConstants.INVALID_CARD_DETAILS);
	}
	
/**
 * Just a basic level tests to check if amount and currency are present in request and amount contains only integers.
 * @param cardPaymentInfo
 * @return
 */
		private boolean isInputValid(CardPaymentInfo cardPaymentInfo) {
			
				if(cardPaymentInfo.getAmount() != null && cardPaymentInfo.getCurrency() != null 
														&& containsOnlyDigits(cardPaymentInfo.getAmount())) {
					return true;
				}
				throw new PaymentExceptions(PaymentExceptionConstants.ENTER_PROPER_AMOUNT);
			}

/**
 * Basic level checks to see valid card details are present and card has not reached expiration date
 * @param cardDetails
 * @return
 */
		private boolean areCardDetailsValid(CardDetails cardDetails) {
				
			if(cardDetails != null && cardDetails.getCvv() != null && cardDetails.getNumber() != null && cardDetails.getExpirationMonth() !=null
					&& cardDetails.getExpirationYear() != null 
					&& cardDetails.getCvv().length() == 3 && containsOnlyDigits(cardDetails.getCvv())
								&& !isExpirationDateReached(cardDetails.getExpirationMonth(),cardDetails.getExpirationYear())
																		 && containsOnlyDigits(cardDetails.getNumber())) {
				return true;
			}		
			return false;
			}
/**
 * generates the transaction record so that it could be saved to the bank
 * @param cardPaymentInfo
 * @param bankTransactionResult
 * @param timeStamp
 * @return
 */
		private TransactionDetails generateAndSaveTransactionRecord(CardPaymentInfo cardPaymentInfo,BankResponseClass bankTransactionResult,
				Timestamp timeStamp) {

				TransactionDetails transactionDetails = new TransactionDetails();
				transactionDetails.setBankTransactionId(bankTransactionResult.getBankTransactionId());
				transactionDetails.setAuthorization_code(bankTransactionResult.getAuthorization_code());
				transactionDetails.setStatus(bankTransactionResult.getStatus());
				transactionDetails.setTimeOrderCompleted(bankTransactionResult.getTimeOrderCompleted());
				transactionDetails.setCurrency(cardPaymentInfo.getCurrency());
				transactionDetails.setAmount(cardPaymentInfo.getAmount());
				transactionDetails.setPaymentMode(cardPaymentInfo.getType());
				transactionDetails.setPaymentId(cardPaymentInfo.getCardDetails().getNumber());
				transactionDetails.setTimeOrderReceived(timeStamp);
				if(paymentRepository != null) {
					paymentRepository.save(transactionDetails);
				}
				
				return transactionDetails;
				
				}

		/**
		 * Generates the final response for the card Payment
		 * @param transactionDetails
		 * @return
		 */
	private FinalResponseClass generateFinalResponse(TransactionDetails transactionDetails) {
		
		FinalResponseClass finalResponseClass = new FinalResponseClass();
		finalResponseClass.setAmount(transactionDetails.getAmount());
		finalResponseClass.setCurrency(transactionDetails.getCurrency());
		finalResponseClass.setType(transactionDetails.getPaymentMode());
		finalResponseClass.setExtraDetails("number", transactionDetails.getPaymentId());
		finalResponseClass.setStatus(transactionDetails.getStatus());
		finalResponseClass.setAuthorization_code(transactionDetails.getAuthorization_code());
		finalResponseClass.setTime(transactionDetails.getTimeOrderCompleted());
		
		return finalResponseClass;
	}
	

	private boolean isExpirationDateReached(String expirationMonth, String expirationYear) {
		int expMonth = Integer.parseInt(expirationMonth);
		int expYear = Integer.parseInt(expirationYear);
		
		Calendar calender = Calendar.getInstance();
		int currYear = calender.get(Calendar.YEAR);
		int currMonth = calender.get(Calendar.MONTH);
		
		if(expYear > currYear || (expYear == currYear && expMonth>=currMonth)) {
			return false;
		}
		return true;
	}

	private Boolean containsOnlyDigits(String attribute) {
		
		attribute = attribute.trim();
		for(int i=0;i<attribute.length();i++) {
			if( !Character.isDigit(attribute.charAt(i)) ) return false;
		}
		return true;
	}

	
}
