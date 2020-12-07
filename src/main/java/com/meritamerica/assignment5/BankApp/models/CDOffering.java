package com.meritamerica.assignment5.BankApp.models;

import javax.validation.constraints.NotNull;

public class CDOffering {
	@NotNull(message = "Tern not found")
	int term ;
	@NotNull(message = "Interest rate not found")
	double interestRate;	
		
	public CDOffering(){
		this.term = 0;
		this.interestRate = 0;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	

}
