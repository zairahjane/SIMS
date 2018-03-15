package com.sims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sims.domain.Medication;
import com.sims.domain.MedicationRepo;
import com.sims.domain.Swine;
import com.sims.domain.Medicine;


@Controller
public class MedicationController {

	@Autowired
	private MedicationRepo medicationRepo;
	
	@GetMapping("/swine/{swine}/medication/all")
	public String getMedication(@PathVariable Swine swine, Model model) {
		return "medicationList";
	}
	
	@GetMapping("/swine/{swine}/medication/add")
	public String getNewMedicationForm(@PathVariable Swine swine, Model model) {
		model.addAttribute("medication", new Medication());
		return "medication";
	}
	
	@PostMapping("/swine/{swine}/medication/add")
	public String saveNewMedication(@PathVariable Swine swine,
			@ModelAttribute Medication medication) {
		medication.setSwine(swine);
		medicationRepo.save(medication);
		return "redirect:/swine/"+swine.getSwineID()+"/medication/all";
	}	
	
}
