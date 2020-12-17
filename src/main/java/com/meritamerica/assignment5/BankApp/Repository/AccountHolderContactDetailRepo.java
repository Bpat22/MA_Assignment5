package com.meritamerica.assignment5.BankApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.BankApp.models.AccountHolderContactDetails;

public interface AccountHolderContactDetailRepo extends JpaRepository<AccountHolderContactDetails, Integer> {

}
