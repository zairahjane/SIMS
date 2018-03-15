package com.sims.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Weight {

	@Id
	@GeneratedValue
	private long weightID;
	
	private Date weightDate;
	
	private Double weight;		
	
	@ManyToOne
	private Swine swine;
	
	public long getWeightID() {
		return weightID;
	}
	public void setWeightID(long weightID) {
		this.weightID = weightID;
	}
	
	public Date getWeightDate() {
		return weightDate;
	}
	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}
	
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Swine getSwine() {
		return swine;
	}

	public void setSwine(Swine swine) {
		this.swine = swine;
	}
	
}
