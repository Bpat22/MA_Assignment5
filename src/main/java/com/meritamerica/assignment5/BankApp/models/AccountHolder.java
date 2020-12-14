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

	 static final long MAX_COMBINED_BALANCE = 250000;
	 //static int nextId = 0;
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column()
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

	 @Column(name = "CHECKING_ACCOUNTS")
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
	 //private List<CheckingAccount> checkingAccounts;

	 @Column(name = "SAVINGS_ACCOUNTS")
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	 //private List<SavingsAccount> savingsAccounts;

	 @Column(name = "CD_ACCOUNTS")
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	 private List<CDAccount> cdAccounts = new ArrayList<CDAccount>();
	 //private List<CDAccount> cdAccounts;
	
	private int numberOfCheckingAccounts;
	
	private double checkingBalance;

	private int numberOfSavingsAccounts;
	
	private double savingsBalance;

	private int numberOfCDAccounts;
	
	private double cdBalance;
	
	//@DecimalMax(value = "250,000.0", inclusive = false, message = "Combined balance can not be over 250,000" )
	double combinedBalance;
	
	public AccountHolder() {
		//this.id = nextId++;
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
	
//*****Checking	
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		checkingAccounts.add(checkingAccount);
	}	
	public CheckingAccount addCheckingAccount(double balance) {
		CheckingAccount checkingAccount = new CheckingAccount(balance);
		return checkingAccount;
	}
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccounts;
	}	
	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.size();
	}
		
//*****Savings
	public void addSavingsAcccount(SavingsAccount savingsAccount) {
		savingsAccounts.add(savingsAccount);
	}
	public SavingsAccount addSavingsAccount(double balance) {
		SavingsAccount savingsAccount = new SavingsAccount(balance);
		return savingsAccount;
	}
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccounts;
	}
	public int getNumberOfSavingsAccounts() {
		return this.savingsAccounts.size();
	}
	
//*****CD 
	public void addCDAcccount(CDAccount cdAccount) {
		cdAccounts.add(cdAccount);
	}
	public List<CDAccount> getCDAccounts(){
		return cdAccounts;
	}	
	public int getNumberOfCDAccounts() {
		return this.cdAccounts.size();
	}

//*****Combined balance
	public double getCombinedBalance() {
		this.combinedBalance = getCheckingBalance() + getSavingsBalance()+ getCDBalance();
		return combinedBalance;
	}
	public double getCheckingBalance() {
		checkingBalance = 0;
		for(CheckingAccount ckB : checkingAccounts) {
			checkingBalance += ckB.getBalance();
		}
		return checkingBalance;
	}
	public double getSavingsBalance() {
		savingsBalance = 0;
		for(SavingsAccount svB : savingsAccounts) {
			savingsBalance += svB.getBalance();
		}
		return savingsBalance;
	}
	public double getCDBalance() {
		cdBalance = 0;
		for(CDAccount cdB : cdAccounts) {
			cdBalance += cdB.getBalance();
		}
		return cdBalance;
	}
		
}
