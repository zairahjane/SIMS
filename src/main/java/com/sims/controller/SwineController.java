package com.sims.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.sims.domain.Swine;
import com.sims.domain.SwineRepo;

@Controller
public class SwineController {

	@Autowired
	private SwineRepo swineRepo;

	@GetMapping("/swine")
	public String getDefaultSwinePage() {
		return "redirect:/swine/all";
	}
	
	@GetMapping("/swine/all")
	public String getSwine(){
		return "swineList";
	}
	
	//get swine form
	@GetMapping("/swine/addswine")
	public String getSwineForm(Model model) {
		model.addAttribute("swine", new Swine());
		model.addAttribute("pageLabel","Add Swine");
		return "swine";
	}

	//save new swine
	@PostMapping("/swine/addswine")
	public String createAddSwine(@ModelAttribute Swine swine) {
		swineRepo.save(swine);
		return "redirect:/swine";
	}

	//get swine form for update
	@GetMapping("/swine/{id}")
	public String getUpdateForm(@PathVariable Long id, Model model){
		model.addAttribute("swine", swineRepo.findOne(id));
		model.addAttribute("pageLabel","Update swine "+id);
		return "swine";
	}

	//update swine
	@PostMapping("/swine/{id}")
	public String updateSwine(@ModelAttribute Swine swine){
		swineRepo.save(swine);
		return "redirect:/swine/all";
	}
	
	

}
