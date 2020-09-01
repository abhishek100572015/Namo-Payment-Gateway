package com.Namo.Backend.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The model in which data will get saved to the SQL database.
 * @author Abhishek
 *
 */
@Entity
public class TransactionDetails {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String transactionId;
	
	private String bankTransactionId;
	private String authorization_code;
	private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp timeOrderCompleted;

	private String amount;
	private String paymentMode;
	private String paymentId;
	private String currency;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp timeOrderReceived;
	
	public String getTransactionId() {
		return transactionId;
	}
	public String getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public Timestamp getTimeOrderCompleted() {
		return timeOrderCompleted;
	}
	public Timestamp getTimeOrderReceived() {
		return timeOrderReceived;
	}
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public void setTimeOrderCompleted(Timestamp timeOrderCompleted) {
		this.timeOrderCompleted = timeOrderCompleted;
	}
	public void setTimeOrderReceived(Timestamp timestamp) {
		this.timeOrderReceived = timestamp;
	}
	
	public TransactionDetails() {
		super();
	}
	
	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}
	public String getBankTransactionId() {
		return bankTransactionId;
	}
	
	
	
	public TransactionDetails(String transactionId, String bankTransactionId, String authorization_code, String status,
			Timestamp timeOrderCompleted, String amount, String paymentMode, String paymentId,
			Timestamp timeOrderReceived) {
		super();
		this.transactionId = transactionId;
		this.bankTransactionId = bankTransactionId;
		this.authorization_code = authorization_code;
		this.status = status;
		this.timeOrderCompleted = timeOrderCompleted;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymentId = paymentId;
		this.timeOrderReceived = timeOrderReceived;
	}
	
	

}
