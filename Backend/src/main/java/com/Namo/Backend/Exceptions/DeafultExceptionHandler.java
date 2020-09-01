package com.Namo.Backend.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Generic exception handler
 * @author Abhishek
 *
 */
@ControllerAdvice
@RestController
public class DeafultExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(PaymentExceptions.class)
	public final ResponseEntity<Object> handlePaymentExceptions(PaymentExceptions paymentException, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), paymentException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<Object> handleNumberFormatException(NumberFormatException numberFormatException, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "NumberFormat Exception for "+numberFormatException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGeneralException(Exception exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
