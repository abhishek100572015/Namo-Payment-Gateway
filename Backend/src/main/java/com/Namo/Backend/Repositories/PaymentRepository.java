package com.Namo.Backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Namo.Backend.Entities.TransactionDetails;

@Component
public interface PaymentRepository extends JpaRepository<TransactionDetails,String>{
	
	

}
