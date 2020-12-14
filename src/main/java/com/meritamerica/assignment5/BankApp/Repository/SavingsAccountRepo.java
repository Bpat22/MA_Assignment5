package com.meritamerica.assignment5.BankApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.BankApp.models.SavingsAccount;


public interface SavingsAccountRepo extends JpaRepository <SavingsAccount, Integer>{

}
