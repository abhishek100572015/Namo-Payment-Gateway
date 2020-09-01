package com.Namo.Backend.PaymentModelClasses;

import java.sql.Timestamp;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * The structure of the final response generated.
 * @author Abhishek
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinalResponseClass {
	
	
	private String amount;
	private String currency;
	private String type;
	
	@JsonProperty("card")
	private HashMap<String,Object> extraDetails;
	
	private String status;
	private String authorization_code;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp time;
	
	
	public FinalResponseClass() {
		
	}

	public FinalResponseClass(String amount, String currency, String type, HashMap<String, Object> extraDetails, String status,
			String authorization_code, Timestamp time) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.type = type;
		this.extraDetails = extraDetails;
		this.status = status;
		this.authorization_code = authorization_code;
		this.time = time;
	}
	
	public String getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	public String getType() {
		return type;
	}
	public HashMap<String, Object> getExtraDetails() {
		return extraDetails;
	}
	public String getStatus() {
		return status;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public Timestamp getTime() {
		return time;
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
	public void setExtraDetails(String key,String value) {
		if(extraDetails == null) {
			extraDetails = new HashMap<>();
		}
		extraDetails.put(key, value);
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "FinalResponseClass [amount=" + amount + ", currency=" + currency + ", type=" + type + ", extraDetails="
				+ extraDetails + ", status=" + status + ", authorization_code=" + authorization_code + ", time=" + time
				+ "]";
	}
	
	
}
