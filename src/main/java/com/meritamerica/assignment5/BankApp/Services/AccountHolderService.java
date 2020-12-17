package com.meritamerica.assignment5.BankApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment5.BankApp.Repository.AccountHolderContactDetailRepo;
import com.meritamerica.assignment5.BankApp.Repository.AccountHolderRepo;
import com.meritamerica.assignment5.BankApp.Repository.CDAccountRepo;
import com.meritamerica.assignment5.BankApp.Repository.CDOfferingRepo;
import com.meritamerica.assignment5.BankApp.Repository.CheckingAccountRepo;
import com.meritamerica.assignment5.BankApp.Repository.SavingsAccountRepo;
import com.meritamerica.assignment5.BankApp.models.AccountHolder;
import com.meritamerica.assignment5.BankApp.models.AccountHolderContactDetails;
import com.meritamerica.assignment5.BankApp.models.CDAccount;
import com.meritamerica.assignment5.BankApp.models.CDOffering;
import com.meritamerica.assignment5.BankApp.models.CheckingAccount;
import com.meritamerica.assignment5.BankApp.models.SavingsAccount;

@Service
public class AccountHolderService{

	@Autowired
	private AccountHolderRepo ahRepo;
	@Autowired
	private CheckingAccountRepo caRepo;
	@Autowired
	private SavingsAccountRepo saRepo;
	@Autowired
	private CDAccountRepo cdRepo;
	@Autowired
	private AccountHolderContactDetailRepo contactRepo;
	//@Autowired
	//private CDOfferingRepo cdoRepo;
	
	public AccountHolderContactDetails addContactDetails(AccountHolderContactDetails contact) {
		return contactRepo.save(contact);
	}
	
	public AccountHolderService() {
		super();
	}
	
	public List<AccountHolder> getAccountHolders(){
		return ahRepo.findAll();
	}
	public AccountHolder getAccountHolderById(int id) {
		return ahRepo.findById(id).orElse(null);
	}	
	public AccountHolder postAccountHolder(AccountHolder accountHolder) {
		return ahRepo.save(accountHolder);
	}
	
	
	public List<CheckingAccount> getCheckingAccount(){
		return caRepo.findAll();
	}		
	public CheckingAccount getCheckingAccountById(int id) {
		return caRepo.findById(id).orElse(null);
	}
	public CheckingAccount postCheckingAccount(AccountHolder accountHolder, CheckingAccount checkingAccount) {
		checkingAccount.setAccountHolder(accountHolder);
		return caRepo.save(checkingAccount);
	}
	
	
	public List<SavingsAccount> getSavingsAccount(){
		return saRepo.findAll();
	}
	public SavingsAccount getSavingsAccountById(int id) {
		return saRepo.findById(id).orElse(null);
	}
	public SavingsAccount postSavingsAccount(AccountHolder accountHolder, SavingsAccount savingsAccount) {
		savingsAccount.setAccountHolder(accountHolder);
		return saRepo.save(savingsAccount);
	}
	
	
	public List<CDAccount> getCDAccount(){
		return cdRepo.findAll();
	}
	public CDAccount getCDAccountById(int id) {
		return cdRepo.findById(id).orElse(null);
	}
	public CDAccount postCDAccount(AccountHolder accountHolder, CDAccount cdAccount) {
		cdAccount.setAccountHolder(accountHolder);
		//cdAccount.setCDOffering(cdOffering); CDOffering cdOffering, 
		return cdRepo.save(cdAccount);
	}

}
