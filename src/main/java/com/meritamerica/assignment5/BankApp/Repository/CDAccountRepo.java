package com.meritamerica.assignment5.BankApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.BankApp.models.CDAccount;

public interface CDAccountRepo extends JpaRepository <CDAccount, Integer>{

}
