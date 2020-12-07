package com.meritamerica.assignment5.BankApp.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;

public class AccountHolder {

	static int nextId = 1;
	 int id;
	 @NotNull(message = "First name field requires value ")
	 @NotBlank(message = "First name can not be blank")
	 String firstName;
	// @NotNull(message = "Middle name field requires value ")
	 //@NotBlank(message = "Middle name can not be blank")
	 String middleName;
	 @NotNull(message = "Last name field requires value ")
	 @NotBlank(message = "Last name can not be blank")
	 String lastName;
	 @NotNull(message = "SSN field requires value ")
	 @NotBlank(message = "SSN can not be blank")
	 String ssn;
	
	private List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
	private List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	private List<CDAccount> cdAccounts = new ArrayList<CDAccount>();

	
	public AccountHolder() {
		this.id = nextId++;
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.ssn = "";
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		checkingAccounts.add(checkingAccount);
		return checkingAccount;
	}
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccounts;
	}
	
	public SavingsAccount addSavingsAcccount(SavingsAccount savingsAccount) {
		savingsAccounts.add(savingsAccount);
		return savingsAccount;
	}
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccounts;
	}
	
	public CDAccount addCDAcccount(CDAccount cdAccount) {
		cdAccounts.add(cdAccount);
		return cdAccount;
	}
	public List<CDAccount> getCDAccounts(){
		return cdAccounts;
	}

}
