package com.sims.controller;

import java.sql.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sims.domain.Swine;
import com.sims.domain.SwineRepo;


@RestController
public class SwineRController {
	
	@Autowired 
	SwineRepo swineRepo;
	/*
	 * Get all swine
	 */
	@GetMapping("api/swineList")
	public Page<Swine> getPagedItems(Pageable pageable, @RequestParam(defaultValue="") String searchBy, 
			@RequestParam(required=false) String searchValue,
			@RequestParam(required= false) Date date) {
		Page<Swine> pageItem;

		
		switch (searchBy) {
		case "type" :
			pageItem = swineRepo.findByTypeStartingWith(searchValue, pageable);
			break;
		case "breed" :
			pageItem = swineRepo.findByBreedStartingWith(searchValue, pageable);
			break;
		case "gender" :
			pageItem = swineRepo.findByGenderStartingWith(searchValue, pageable);
			break;	
		case "bday" :
			pageItem = swineRepo.findByBdayStartingWith(date, pageable);
			break;	
		default:
			pageItem = swineRepo.findAll(pageable);	
			break;
		}	
		return pageItem;	

	}	
}
