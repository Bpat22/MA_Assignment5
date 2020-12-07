package com.meritamerica.assignment5.BankApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class InterestTermLimitException extends Exception{

	public InterestTermLimitException(String msg) {
	
		super (msg);
	
			//System.out.println("cannot deposit more than 1000");
	}
}
