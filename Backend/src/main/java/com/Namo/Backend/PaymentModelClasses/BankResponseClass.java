package com.Namo.Backend.PaymentModelClasses;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Model of the response sent by the bank
 * @author Abhishek
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankResponseClass {
	
//	{
//	    "bankTransactionId": "1234",
//	    "authorization_code": "2345",
//	    "status": "success",
//	    "timeOrderCompleted": "2020-05-16 07:00:00"
//	}
	
	private String bankTransactionId;
	private String authorization_code;
	private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp timeOrderCompleted;
	
	
	public String getBankTransactionId() {
		return bankTransactionId;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public String getStatus() {
		return status;
	}
	public Timestamp getTimeOrderCompleted() {
		return timeOrderCompleted;
	}
	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTimeOrderCompleted(Timestamp timeOrderCompleted) {
		this.timeOrderCompleted = timeOrderCompleted;
	}
		
	
}
