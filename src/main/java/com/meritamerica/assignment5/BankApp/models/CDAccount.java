package com.meritamerica.assignment5.BankApp.models;

import javax.validation.constraints.NotNull;

public class CDAccount {

	static int nextId = 1;
	long accountNumber;
	@NotNull(message ="Balance not found")
	double balance;
	@NotNull(message ="Interest Rate not found")
	double interestRate = 0.025;
	@NotNull(message ="Term not found")
	int term;
	//@NotNull(message ="Date not found")
	long openedOn;
	 
	public CDAccount(){
		this.accountNumber = nextId++;
		this.balance = 0;
		this.term = 0;
		this.interestRate = 0;
		this.openedOn = 0;
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

	public long getopenedOn() {
		return openedOn;
	}

	public void setopenedOn(long openedOn) {
		this.openedOn = openedOn;
	}

}
