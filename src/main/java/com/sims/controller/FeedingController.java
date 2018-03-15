package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sims.domain.Feeding;
import com.sims.domain.FeedingRepo;
import com.sims.domain.Swine;
import com.sims.domain.Food;


@Controller
public class FeedingController {

	@Autowired
	private FeedingRepo feedingRepo;
	
	@GetMapping("/swine/{swine}/feeding/all")
	public String getFeeding(@PathVariable Swine swine, Model model) {
		return "feedingList";
	}
	
	@GetMapping("/swine/{swine}/feeding/add")
	public String getNewFeedingForm(@PathVariable Swine swine, Model model) {
		model.addAttribute("feeding", new Feeding());
		return "feeding";
	}
	
	@PostMapping("/swine/{swine}/feeding/add")
	public String saveNewFeeding(@PathVariable Swine swine,
			@ModelAttribute Feeding feeding) {
		feeding.setSwine(swine);
		feedingRepo.save(feeding);
		return "redirect:/swine/"+swine.getSwineID()+"/feeding/all";
	}	
	
}
