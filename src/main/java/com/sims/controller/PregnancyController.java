package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sims.domain.Pregnancy;
import com.sims.domain.PregnancyRepo;
import com.sims.domain.Swine;

@Controller
public class PregnancyController {

	@Autowired
	private PregnancyRepo pregnancyRepo;
	
	@GetMapping("/swine/{swine}/pregnancy/all")
	public String getPregnancy(@PathVariable Swine swine, Model model) {
		return "pregnancyList";
	}
	
	@GetMapping("/swine/{swine}/pregnancy/add")
	public String getNewPregnancytForm(@PathVariable Swine swine, Model model) {
		model.addAttribute("pregnancy", new Pregnancy());
		return "pregnancy";
	}
	
	@PostMapping("/swine/{swine}/pregnancy/add")
	public String saveNewPregnancy(@PathVariable Swine swine, 
			@ModelAttribute Pregnancy pregnancy) {
		pregnancy.setSwine(swine);
		pregnancyRepo.save(pregnancy);
		return "redirect:/swine/"+swine.getSwineID()+"/pregnancy/all";
	}	
	
}
