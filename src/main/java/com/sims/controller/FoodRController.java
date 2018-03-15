package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sims.domain.Food;
import com.sims.domain.FoodRepo;


@RestController
public class FoodRController {
	
	@Autowired 
	FoodRepo foodRepo;
	/*
	 * Get all food
	 */
	@GetMapping("api/foodList")
	public Page<Food> getPagedItems(Pageable pageable, @RequestParam(defaultValue="") String searchBy, 
			@RequestParam(defaultValue="") String searchValue) {
		Page<Food> pageItem;
		
		switch (searchBy) {
		case "prodname" :
			pageItem = foodRepo.findByProdnameStartingWith(searchValue, pageable);
			break;
		case "classification" :
			pageItem = foodRepo.findByClassificationStartingWith(searchValue, pageable);
			break;	
		case "quantity" :
			pageItem = foodRepo.findByQuantityStartingWith(searchValue, pageable);
			break;	
		case "weight" :
			pageItem = foodRepo.findByWeightStartingWith(searchValue, pageable);
			break;	
		case "expdate" :
			pageItem = foodRepo.findByExpdateStartingWith(searchValue, pageable);
			break;	
		default:
			pageItem = foodRepo.findAll(pageable);	
			break;
		}	
		return pageItem;	
	}
	
	
	
	
}
