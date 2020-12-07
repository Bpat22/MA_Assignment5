package com.meritamerica.assignment5.BankApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class ExceedsAvailableBalanceException  extends Exception{
	
	public ExceedsAvailableBalanceException(String msg) {
		
		super (msg);
		//System.out.println("not enough balance");
		
		
	}
}
