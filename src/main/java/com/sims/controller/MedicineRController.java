package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sims.domain.Medicine;
import com.sims.domain.MedicineRepo;


@RestController
public class MedicineRController {
	
	@Autowired 
	MedicineRepo medicineRepo;
	/*
	 * Get all medicine
	 */
	@GetMapping("api/medicineList")
	public Page<Medicine> getPagedItems(Pageable pageable, @RequestParam(defaultValue="") String searchBy, 
			@RequestParam(defaultValue="") String searchValue) {
		Page<Medicine> pageItem;
		
		switch (searchBy) {
		case "type" :
			pageItem = medicineRepo.findByTypeStartingWith(searchValue, pageable);
			break;
		case "name" :
			pageItem = medicineRepo.findByNameStartingWith(searchValue, pageable);
			break;	
		case "quantity" :
			pageItem = medicineRepo.findByQuantityStartingWith(searchValue, pageable);
			break;	
		case "expdate" :
			pageItem = medicineRepo.findByExpdateStartingWith(searchValue, pageable);
			break;
		default:
			pageItem = medicineRepo.findAll(pageable);	
			break;
		}	
		return pageItem;	
	}
	
	
	
	
}
