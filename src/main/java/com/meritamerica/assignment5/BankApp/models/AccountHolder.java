package com.meritamerica.assignment5.BankApp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

//*** to create table
@Entity
@Table(name = "ACCOUNT_HOLDER")
public class AccountHolder {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_holder_generator")
	 @Column(name = "AH_ID")
	 private int id;	 
	 
	 @NotBlank(message = "First name can not be blank")
	 @Size(min = 2, max = 20, message = "First name must be at least 2 characters")
	 @Column(name = "FIRST_NAME")
	 String firstName;
	
	 @Column(name = "MIDDLE_NAME")
	 String middleName;
	
	 @NotBlank(message = "Last name can not be blank")
	 @Size(min = 2, max = 20, message = "Last name must be at least 2 characters")
	 @Column(name = "LAST_NAME")
	 String lastName;

	 @NotBlank(message = "SSN can not be blank")
	 @Size(min = 9, max = 9, message = "SSN number must be 9 digits")
	 @Column(name = "SSN")
	 String ssn;
	 

	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private AccountHolderContactDetails contact;

	 //@Column(name = "CHECKING_ACCOUNTS")
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private List<CheckingAccount> checkingAccounts;

	 //@Column(name = "SAVINGS_ACCOUNTS")
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private List<SavingsAccount> savingsAccounts;

	 //@Column(name = "CD_ACCOUNTS")
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private List<CDAccount> cdAccounts;
	
	//@DecimalMax(value = "250,000.0", inclusive = false, message = "Combined balance can not be over 250,000" )
	@JsonIgnore
	 private double totalBalance;
	
	public AccountHolder() {
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.ssn = "";		
	}	
	
	public AccountHolderContactDetails getContact() {
		return contact;
	}
	public void setAhContactDetail(AccountHolderContactDetails contact) {
		this.contact = contact;
	}

	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccounts;
	}	
	public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}

	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccounts;
	}
	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
	
	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	
	public double getTotalBalance() {
		return combinedBalance();
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
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
	
//*****Combined balance
	public double combinedBalance() {
		for(CheckingAccount ckB : checkingAccounts) {
			totalBalance = ckB.getBalance();
		}
		for(SavingsAccount saB : savingsAccounts) {
			totalBalance = saB.getBalance();
		}
		for(CDAccount cdaB : cdAccounts) {
			totalBalance = cdaB.getBalance(); 
		}
		return totalBalance;
	}
	
		
}
