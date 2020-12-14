package com.meritamerica.assignment5.BankApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.BankApp.models.CheckingAccount;

public interface CheckingAccountRepo extends JpaRepository <CheckingAccount, Integer>{

}
