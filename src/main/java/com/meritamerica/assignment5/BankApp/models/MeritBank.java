package com.meritamerica.assignment5.BankApp.models;

import java.util.ArrayList;
import java.util.List;

public class MeritBank {

	private static List<AccountHolder>accounts = new ArrayList<AccountHolder>();
	private static long accountNumber = 1;
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		accounts.add(accountHolder);
	}
	public static List<AccountHolder> getAccountHolders(){
		return accounts;
	}	
	public static int getAccountLength() {
		return accounts.size();
	}
	public static long getNextAccountNumber() {
		return accountNumber;
	}
}
