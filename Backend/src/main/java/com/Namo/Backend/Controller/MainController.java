package com.Namo.Backend.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Namo.Backend.Exceptions.PaymentExceptionConstants;
import com.Namo.Backend.Exceptions.PaymentExceptions;
import com.Namo.Backend.PaymentLogic.Services.PaymentService;
import com.Namo.Backend.PaymentModelClasses.FinalResponseClass;

@RestController
public class MainController {


	@Autowired
	PaymentService paymentService;
	@PostMapping("/payment")
	@ResponseBody
	public FinalResponseClass doPayment(@RequestBody HashMap<String, Object> paymentInfoMap) throws PaymentExceptions {
		if(paymentInfoMap != null) {
				return paymentService.selectPaymentMethod(paymentInfoMap);
			
		}
		throw new PaymentExceptions(PaymentExceptionConstants.EMPTY_REQUEST_EXCEPTION);
	}

}
