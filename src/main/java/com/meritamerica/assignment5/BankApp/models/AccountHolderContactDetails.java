package com.meritamerica.assignment5.BankApp.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ACCOUNT_HOLDER_DETAIL")
public class AccountHolderContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
	@Column(name = "CONTACT_ID")
	private int id;
	
	private int phoneNo;
	private String email;
	
	@OneToOne
	@JoinColumn(name= "ACCOUNT_HOLDER_ID", nullable = false)
	@JsonIgnore
	private AccountHolder accountHolder;
	
	public AccountHolderContactDetails() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
	
}
