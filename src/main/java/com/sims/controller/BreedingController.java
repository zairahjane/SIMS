package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sims.domain.Breeding;
import com.sims.domain.BreedingRepo;
import com.sims.domain.Swine;

@Controller
public class BreedingController {

	@Autowired
	private BreedingRepo breedingRepo;
	
	@GetMapping("/swine/{swine}/breeding/all")
	public String getBreeding(@PathVariable Swine swine, Model model) {
		return "breedingList";
	}
	
	@GetMapping("/swine/{swine}/breeding/add")
	public String getNewBreedingForm(@PathVariable Swine swine, Model model) {
		model.addAttribute("breeding", new Breeding());
		return "breeding";
	}
	
	@PostMapping("/swine/{swine}/breeding/add")
	public String saveNewBreeding(@PathVariable Swine swine, 
			@ModelAttribute Breeding breeding) {
		breeding.setSwine(swine);
		breedingRepo.save(breeding);
		return "redirect:/swine/"+swine.getSwineID()+"/breeding/all";
	}	
	
}
