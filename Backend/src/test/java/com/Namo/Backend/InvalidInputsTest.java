package com.Namo.Backend;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Namo.Backend.Controller.MainController;
import com.Namo.Backend.Entities.TransactionDetails;
import com.Namo.Backend.Exceptions.PaymentExceptionConstants;
import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentLogic.CardPaymentLogic;
import com.Namo.Backend.PaymentLogic.Services.PaymentService;
import com.Namo.Backend.Repositories.PaymentRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
class InvalidInputsTest {

	@Autowired 
	MockMvc mvc;
	@MockBean
	 PaymentService paymentService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void invalidCardDetails() throws Exception
	{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/payment")
				.accept(MediaType.APPLICATION_JSON).content(PaymentGatewayTestsConstants.REQUEST_WITH_NO_AMOUNT)
				.contentType(MediaType.APPLICATION_JSON);
       		thrown.expect(PaymentExceptions.class);
     		thrown.expectMessage(is(PaymentExceptionConstants.ENTER_PROPER_AMOUNT));	
		MvcResult result = mvc.perform(requestBuilder).andReturn();

	}
	
	
	@Test
	public void noValidAmountType() throws Exception
	{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/payment")
				.accept(MediaType.APPLICATION_JSON).content(PaymentGatewayTestsConstants.REQUEST_WITH_NO_AMOUNT)
				.contentType(MediaType.APPLICATION_JSON);
       		thrown.expect(PaymentExceptions.class);
     		thrown.expectMessage(is(PaymentExceptionConstants.PAYMENT_METHOD_NOT_SUPPORTED));	
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

	}
	
	
	@Test
	public void expiredCard() throws Exception
	{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/payment")
				.accept(MediaType.APPLICATION_JSON).content(PaymentGatewayTestsConstants.EXPIRED_CARD)
				.contentType(MediaType.APPLICATION_JSON);
       		thrown.expect(PaymentExceptions.class);
     		thrown.expectMessage(is(PaymentExceptionConstants.INVALID_CARD_DETAILS));	
		MvcResult result = mvc.perform(requestBuilder).andReturn();

	}


}
