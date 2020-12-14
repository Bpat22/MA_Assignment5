package com.meritamerica.assignment5.BankApp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.BankApp.Services.AccountHolderService;
import com.meritamerica.assignment5.BankApp.Services.CDOfferingService;
import com.meritamerica.assignment5.BankApp.exceptions.InterestTermLimitException;
import com.meritamerica.assignment5.BankApp.models.CDOffering;
import com.meritamerica.assignment5.BankApp.models.MeritBank;


@RestController
public class CDOfferingController {

	@Autowired
	//CDOfferingService service;
	AccountHolderService service;
	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/CDOfferings")
	public CDOffering postCDOffering(@Valid @RequestBody CDOffering cdOffering) {
		MeritBank.addCDOffering(cdOffering);
		return service.postCDOffering(cdOffering);
	}
	
	@GetMapping(value ="/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOfferings(){
		return service.getCDOfferings();
	}
	
	
}
