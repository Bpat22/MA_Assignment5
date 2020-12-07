package com.meritamerica.assignment5.BankApp.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.expression.ParseException;

public abstract class BankAccount {
	
	private double  balance ;
	private double interestRate;
	private long accountNumber;
	private String date;
		
	 BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	 BankAccount(long accountNumber, double balance, double interestRate){
		 this.accountNumber = accountNumber;
		 this.balance = balance;
		 this.interestRate = interestRate;
	 }
	BankAccount(long accountNumber, double balance, double interestRate, String date){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.date= date;
	}
	

	public long getAccountNumber() 
	{
		return this.accountNumber;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	public double getInterestRate() 
	{
		return this.interestRate;
	}
	
	public boolean withdraw(double amount)
	{
		if((this.balance - amount) >= 0) 
		{
			this.balance = this.balance - amount;
			return true;
		} else
			{
			
			return false;
			}	
	}
	
	public boolean deposit(double amount) 
	{
		if(((this.balance + amount) <= 250000) && amount > 0)
		{
			this.balance = this.balance + amount;
			return true;
		} else 
			return false;	
	}
	
}
