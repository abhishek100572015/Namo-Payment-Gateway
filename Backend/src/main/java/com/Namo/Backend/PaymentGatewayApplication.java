package com.Namo.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.Namo.Backend.Exceptions.DeafultExceptionHandler;

@SpringBootApplication
@Import(DeafultExceptionHandler.class)
public class PaymentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayApplication.class, args);
	}

}
