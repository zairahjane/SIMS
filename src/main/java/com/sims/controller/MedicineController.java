package com.sims.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sims.domain.Medicine;
import com.sims.domain.MedicineRepo;

@Controller
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineRepo medicineRepo;

	@GetMapping
	public String showDefaultMedicinePage() {
		return "redirect:/medicine/all";
	}
	
	@GetMapping("/all")
	public String showAllItems(){
		return "medicineList";
	}
	
	//get medicine form
	@GetMapping("/addmedicine")
	public String getMedicineForm(Model model) {
		model.addAttribute("medicine", new Medicine());
		model.addAttribute("pageLabel","Add Medicine");
		return "medicine";
	}

	//save new medicine
	@PostMapping("/addmedicine")
	public String createAddMedicine(@ModelAttribute Medicine medicine) {
		medicineRepo.save(medicine);
		return "redirect:/medicine";
	}

	//get medicine form for update
	@GetMapping("/{id}")
	public String getUpdateForm(@PathVariable Long id, Model model){
		model.addAttribute("medicine", medicineRepo.findOne(id));
		model.addAttribute("pageLabel","Update medicine "+id);
		return "medicine";
	}

	//update medicine
	@PostMapping("/{id}")
	public String updateMedicine(@ModelAttribute Medicine medicine){
		medicineRepo.save(medicine);
		return "redirect:/medicine/all";
	}
	
	

}
