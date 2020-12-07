package com.meritamerica.assignment5.BankApp.models;

import javax.validation.constraints.NotNull;

public class CheckingAccount{
	static int nextId =1;	
	long accountNumber;
	@NotNull(message="Balance not found")
	double balance;
	@NotNull(message="Interest rate not found")
	double interestRate;
	@NotNull(message="Date not found")
	long openedOn ;
	
	public CheckingAccount() {
		this.balance = 0;
		this.interestRate = .0001;
		this.openedOn = 0;
		this.accountNumber = nextId++;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public long getopenedOn() {
		return openedOn;
	}
	public void setopenedOn(long openedOn) {
		this.openedOn = openedOn;
	}

}
