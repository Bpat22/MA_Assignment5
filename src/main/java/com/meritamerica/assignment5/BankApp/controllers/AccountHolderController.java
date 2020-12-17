package com.meritamerica.assignment5.BankApp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.BankApp.Services.AccountHolderService;
import com.meritamerica.assignment5.BankApp.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.BankApp.exceptions.InterestTermLimitException;
import com.meritamerica.assignment5.BankApp.exceptions.NegativeBalanceException;
import com.meritamerica.assignment5.BankApp.exceptions.NotFoundException;
import com.meritamerica.assignment5.BankApp.models.AccountHolder;
import com.meritamerica.assignment5.BankApp.models.CDAccount;
import com.meritamerica.assignment5.BankApp.models.CDOffering;
import com.meritamerica.assignment5.BankApp.models.CheckingAccount;
import com.meritamerica.assignment5.BankApp.models.MeritBank;
import com.meritamerica.assignment5.BankApp.models.SavingsAccount;

@RestController
public class AccountHolderController {
	
	@Autowired
	AccountHolderService service;

	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	List<String> strTemp = new ArrayList<String>();

	@ResponseStatus(HttpStatus.CREATED)	
	@PostMapping(value = "/AccountHolders")
	public AccountHolder postAccountHolder(@Valid @RequestBody AccountHolder accountHolder) {
		service.postAccountHolder(accountHolder);
		return accountHolder;		
	}	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value ="/AccountHolders")
	public List<AccountHolder> getAccountHolders(){
		return service.getAccountHolders();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable int id) throws NotFoundException {
		if(service.getAccountHolderById(id) == null) {
			throw new NotFoundException("Account Holder id not found");
		}
		return service.getAccountHolderById(id);
	}
	
//*****Checking Account
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount postCheckingAccount(@Valid @RequestBody CheckingAccount checkingAccount, @PathVariable int id) throws NotFoundException, ExceedsCombinedBalanceLimitException  {
		AccountHolder accountHolder = service.getAccountHolderById(id);
		if(service.getAccountHolderById(id) == null){
			throw new NotFoundException("Account id not found");
		}
		service.postCheckingAccount(accountHolder, checkingAccount);
		return checkingAccount;
	}	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountById(@PathVariable int id) throws NotFoundException {
		if(service.getAccountHolderById(id) == null) {
			throw new NotFoundException("Checking account id not found");
		}
		return service.getAccountHolders().get(id).getCheckingAccounts();
	}
	
//*****Savings Account
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount postSavingsAccount(@Valid @RequestBody SavingsAccount savingsAccount, @PathVariable int id) throws NotFoundException, ExceedsCombinedBalanceLimitException {
		AccountHolder accountHolder = service.getAccountHolderById(id);
		if(service.getAccountHolderById(id) == null){
			throw new NotFoundException("Account id not found");
		}
		service.postSavingsAccount(accountHolder, savingsAccount);
		return savingsAccount;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountById(@PathVariable int id) throws NotFoundException {
		if(service.getAccountHolderById(id) == null){
			throw new NotFoundException("Account id not found");
		}
		return service.getAccountHolders().get(id).getSavingsAccounts();	
	}

//*****CDAccount	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="AccountHolders/{id}/CDAccounts")
	public CDAccount postCDAccount(@Valid @RequestBody CDAccount cdAccount, @PathVariable int id) throws InterestTermLimitException, NotFoundException, ExceedsCombinedBalanceLimitException {
		AccountHolder accountHolder = service.getAccountHolderById(id);
		//CDOffering cdOffering = service.get
			if(service.getAccountHolderById(id) == null){
			throw new NotFoundException("Account id not found");
		}
		service.postCDAccount(accountHolder, cdAccount);
		return cdAccount;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccountById(@PathVariable int id) throws NotFoundException {
		if(service.getAccountHolderById(id) == null){
			throw new NotFoundException("Account id not found");
		}
		return service.getAccountHolders().get(id).getCdAccounts();	
	}
	
}
