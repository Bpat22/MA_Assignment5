package com.meritamerica.assignment5.BankApp.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.expression.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@MappedSuperclass
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)

public abstract class BankAccount {
	
	private static final double MAX_COMBINED_BALANCE = 250000;
	static int nextID = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	//private Long accountNumber;
	private int accountID;
	
	@ManyToOne
	@JoinColumn(name = "ID", nullable = false)
	@JsonIgnore
	public AccountHolder accountHolder;
	
	@NotNull(message="Balance not found")
	@Min(value = 0, message = "Balance must be greater than 0")
	private double balance;
	
	@NotNull(message="Interest rate not found")
	//@DecimalMin(value = "0.0", inclusive = false, message = "Interest Rate must be greater than 0")
	//@DecimalMax(value = "1.0", inclusive = false, message = "Interest Rate must be less than 1" )
	@Column(name = "INTEREST_RATE")
	private double interestRate;
	
	@NotNull(message="Date not found")
	@Column(name = "OPENED_ON")
	private long openedOn ;
			
	public BankAccount() {
		
	}
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
	public long getAccountNumber() {
		return this.accountID;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountID = accountNumber;
	}
	
	public double getBalance()	{
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public long getOpenedOn() {
		return openedOn;
	}
	public void setOpenedOn(long openedOn) {
		this.openedOn = openedOn;
	}
		
}
