package com.meritamerica.assignment5.BankApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment5.BankApp.Repository.CDOfferingRepo;
import com.meritamerica.assignment5.BankApp.models.CDOffering;

@Service
public class CDOfferingService {
		
	@Autowired
	private CDOfferingRepo cdoRepo;
	
	public CDOfferingService() {
		
	}

	public List<CDOffering> getCDOfferings(){
		return cdoRepo.findAll();
	}
	public CDOffering getCDOfferingById(int id) {
		return cdoRepo.findById(id).orElse(null);
	}
	public CDOffering postCDOffering(CDOffering cdOffering) {
		return cdoRepo.save(cdOffering);
	}
	
	
	

}
