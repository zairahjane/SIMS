package com.sims.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sims.domain.Food;
import com.sims.domain.FoodRepo;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodRepo foodRepo;

	@GetMapping
	public String showDefaultFoodPage() {
		return "redirect:/food/all";
	}
	
	@GetMapping("/all")
	public String showAllItems(){
		return "foodList";
	}
	
	//get food form
	@GetMapping("/addfood")
	public String getFoodForm(Model model) {
		model.addAttribute("food", new Food());
		model.addAttribute("pageLabel","Add Food");
		return "food";
	}

	//save new food
	@PostMapping("/addfood")
	public String createAddFood(@ModelAttribute Food food) {
		foodRepo.save(food);
		return "redirect:/food";
	}

	//get food form for update
	@GetMapping("/{id}")
	public String getUpdateForm(@PathVariable Long id, Model model){
		model.addAttribute("food", foodRepo.findOne(id));
		model.addAttribute("pageLabel","Update food "+id);
		return "food";
	}

	//update food
	@PostMapping("/{id}")
	public String updateFood(@ModelAttribute Food food){
		foodRepo.save(food);
		return "redirect:/food/all";
	}
	
	

}
