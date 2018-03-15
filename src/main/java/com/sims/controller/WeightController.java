package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sims.domain.Weight;
import com.sims.domain.WeightRepo;
import com.sims.domain.Swine;

@Controller
public class WeightController {

	@Autowired
	private WeightRepo weightRepo;
	
	@GetMapping("/swine/{swine}/weight/all")
	public String getWeight(@PathVariable Swine swine, Model model) {
		return "weightList";
	}
	
	@GetMapping("/swine/{swine}/weight/add")
	public String getNewWeightForm(@PathVariable Swine swine, Model model) {
		model.addAttribute("weight", new Weight());
		return "weight";
	}
	
	@PostMapping("/swine/{swine}/weight/add")
	public String saveNewWeight(@PathVariable Swine swine, 
			@ModelAttribute Weight weight) {
		weight.setSwine(swine);
		weightRepo.save(weight);
		return "redirect:/swine/"+swine.getSwineID()+"/weight/all";
	}	
	
}
