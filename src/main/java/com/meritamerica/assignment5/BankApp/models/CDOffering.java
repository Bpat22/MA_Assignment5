package com.meritamerica.assignment5.BankApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class CDOffering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@NotNull(message = "Term not found")
	@Min(value = 1, message = "Term must be greate than 0")
	private int term ;
	
	@NotNull(message = "Interest rate not found")
	@DecimalMin(value = "0.0", inclusive = false, message = "Interest Rate must be greater than 0")
	@DecimalMax(value = "1.0", inclusive = false, message = "Interest Rate must be less than 1" )
	private double interestRate;	
		
	public CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}

	public CDOffering() {
		
	}
		
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
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
