package com.meritamerica.assignment5.BankApp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends BankAccount{
	
	private static final double INTEREST_RATE = 0.01;	
			
	public SavingsAccount() {

	}
	public SavingsAccount (double balance) {
		super();
	}
	
}

