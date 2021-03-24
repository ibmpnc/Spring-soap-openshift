package com.springboot.soap.api.emdpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springboot.soap.api.service.LoanEligibilityService;
import com.springboot.spring.soap.api.loaneligibility.Acknowledgement;
import com.springboot.spring.soap.api.loaneligibility.CustomerRequest;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.springboot.com/spring/soap/api/loanEligibility";
	
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {

		

		Acknowledgement ack = service.checkLoanEligibility(request);


		return ack;
	}

}
