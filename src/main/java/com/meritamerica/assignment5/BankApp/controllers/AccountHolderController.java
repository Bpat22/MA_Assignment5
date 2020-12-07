package com.meritamerica.assignment5.BankApp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.BankApp.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.BankApp.exceptions.InterestTermLimitException;
import com.meritamerica.assignment5.BankApp.exceptions.NegativeBalanceException;
import com.meritamerica.assignment5.BankApp.exceptions.NotFoundException;
import com.meritamerica.assignment5.BankApp.models.AccountHolder;
import com.meritamerica.assignment5.BankApp.models.CDAccount;
import com.meritamerica.assignment5.BankApp.models.CDOffering;
import com.meritamerica.assignment5.BankApp.models.CheckingAccount;
import com.meritamerica.assignment5.BankApp.models.SavingsAccount;

@RestController
public class AccountHolderController {

	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	List<String> strTemp = new ArrayList<String>();

	@ResponseStatus(HttpStatus.CREATED)	
	@PostMapping(value = "/AccountHolders")
	public AccountHolder postAccountHolder(@Valid @RequestBody AccountHolder accountHolder) {
		accountHolders.add(accountHolder);
		return accountHolder;		
	}	
	
	//@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value ="/AccountHolders")
	public List<AccountHolder> getAccountHolders(){
		return accountHolders;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable int id) throws NotFoundException {
		if (id > accountHolders.size()){
			throw new NotFoundException("Account id not found");
		}
		return accountHolders.get(id-1);
	}
	
//*****Checking Account
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount postCheckingAccount(@Valid @RequestBody CheckingAccount checkingAccount, @PathVariable int id) throws NegativeBalanceException, ExceedsCombinedBalanceLimitException {
		if(checkingAccount.getBalance()<0) {
			throw new NegativeBalanceException("Negative balance");
		}
		if(checkingAccount.getBalance()>250000) {
			throw new ExceedsCombinedBalanceLimitException("Balance exceeds limit");
		}
		accountHolders.get(id-1).addCheckingAccount(checkingAccount);
		return checkingAccount;
	}	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountById(@PathVariable int id) throws NotFoundException {
		if(id > accountHolders.size()) {
			throw new NotFoundException("Id not found");
		}
		return accountHolders.get(id-1).getCheckingAccounts();		
	}
	
//*****Savings Account
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount postSavingsAccount(@Valid @RequestBody SavingsAccount savingsAccount, @PathVariable int id) throws NegativeBalanceException, ExceedsCombinedBalanceLimitException {
		if(savingsAccount.getBalance()<0) {
			throw new NegativeBalanceException("Negative balance");
		}
		if(savingsAccount.getBalance()>250000) {
			throw new ExceedsCombinedBalanceLimitException("Balance exceeds limit");
		}
		accountHolders.get(id-1).addSavingsAcccount(savingsAccount);
		return savingsAccount;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountById(@PathVariable int id) throws NotFoundException {
		if(id> accountHolders.size()) {
			throw new NotFoundException("Id not found");
		}
		return accountHolders.get(id-1).getSavingsAccounts();	
	}

//*****CDAccount
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="AccountHolders/{id}/CDAccounts")
	public CDAccount postCDAccount(@Valid @RequestBody CDAccount cdAccount, @PathVariable int id) throws NegativeBalanceException, InterestTermLimitException {
		if(cdAccount.getBalance()<0) {
			throw new NegativeBalanceException("Negative balance");
		}
		if(cdAccount.getInterestRate() <= 0 || cdAccount.getInterestRate()>=1) {
			throw new InterestTermLimitException("Interest rate can not be 0 and upto 1%");
		}
		if(cdAccount.getTerm() < 1) {
			throw new InterestTermLimitException("Term has to be more that 1 year");
		}
		accountHolders.get(id-1).addCDAcccount(cdAccount);
		return cdAccount;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccountById(@PathVariable int id) throws NotFoundException {
		if(id > accountHolders.size()) {
			throw new NotFoundException("Id not found");
		}
		return accountHolders.get(id-1).getCDAccounts();	
	}
	
//*****CD Offering
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/CDOfferings")
	public CDOffering postCDOffering(@Valid @RequestBody CDOffering cdOffering) throws InterestTermLimitException {
		if(cdOffering.getTerm() < 1) {
			throw new InterestTermLimitException("Tern can not be less that 1 year");
		}
		if(cdOffering.getInterestRate() <=0 || cdOffering.getInterestRate() >=1) {
			throw new InterestTermLimitException("Interest rate can not be 0 and upto 1%");
		}
		cdOfferings.add(cdOffering);
		return cdOffering;
	}
	
	@GetMapping(value ="/CDOffering")
	public List<CDOffering> getCDOfferings(){
		return cdOfferings;
	}
	
}
