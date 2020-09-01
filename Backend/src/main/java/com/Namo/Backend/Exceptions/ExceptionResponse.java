package com.Namo.Backend.Exceptions;

import java.util.Date;
/**
 * Denotes the format of the exception response
 * @author Abhishek
 *
 */
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

}
