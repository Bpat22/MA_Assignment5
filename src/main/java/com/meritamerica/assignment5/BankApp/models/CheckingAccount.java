package com.meritamerica.assignment5.BankApp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CHECKING")
public class CheckingAccount extends BankAccount{
	
	private static final double INTEREST_RATE = 0.0001;	
	
	public CheckingAccount() {
		super();
	}
	public CheckingAccount (double balance) {
		super();
	}
	
		
}
