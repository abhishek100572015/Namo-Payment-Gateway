package com.Namo.Backend.PaymentModelClasses;

public abstract class PaymentInfo {
	
	public String paymentId;
	public String transactionId;
	public Boolean isSuccess;
	public String amount;
	public String currency;
	public String type;
	
	public String getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	public String getType() {
		return type;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
