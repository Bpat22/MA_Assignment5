package com.meritamerica.assignment5.BankApp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CD")

public class CDAccount extends BankAccount{

	@NotNull(message ="Term not found")
	private int term;
	//@NotNull(message ="Date not found")
	long openedOn;
	 
	
	public CDAccount() {

	}
		
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public long getopenedOn() {
		return openedOn;
	}

	public void setopenedOn(long openedOn) {
		this.openedOn = openedOn;
	}

}
