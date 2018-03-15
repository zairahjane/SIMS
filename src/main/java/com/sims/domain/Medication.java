package com.sims.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medication {

	@Id
	@GeneratedValue
	private long medicationID;
	
	private Date medicationDate;
	
	private String medicationType;		
	
	private Double medicationAmount;	
	
	@ManyToOne
	private Swine swine;
	
	@ManyToOne
	private Medicine medicine;
	
	public long getMedicationID() {
		return medicationID;
	}
	public void setMedicationID(long medicationID) {
		this.medicationID = medicationID;
	}
	
	public Date getMedicationDate() {
		return medicationDate;
	}
	public void setMedicationDate(Date medicationDate) {
		this.medicationDate = medicationDate;
	}
	
	public String getMedicationType() {
		return medicationType;
	}
	public void setMedicationType(String medicationType) {
		this.medicationType = medicationType;
	}
	
	public Double getMedicationAmount() {
		return medicationAmount;
	}
	public void setMedicationAmount(Double medicationAmount) {
		this.medicationAmount = medicationAmount;
	}
	
	public Swine getSwine() {
		return swine;
	}

	public void setSwine(Swine swine) {
		this.swine = swine;
	}
	
	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
}
