package com.sims.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Breeding {

	@Id
	@GeneratedValue
	private long breedingID;
	
	private Date breedingDate;
	
	private long pigletCount;		
	
	@ManyToOne
	private Swine swine;
	
	public long getBreedingID() {
		return breedingID;
	}
	public void setBreedingID(long breedingID) {
		this.breedingID = breedingID;
	}
	
	public Date getBreedingDate() {
		return breedingDate;
	}
	public void setBreedingDate(Date breedingDate) {
		this.breedingDate = breedingDate;
	}
	
	public long getPigletCount() {
		return pigletCount;
	}
	public void setPigletCount(long pigletCount) {
		this.pigletCount=pigletCount;
	}
	
	public Swine getSwine() {
		return swine;
	}

	public void setSwine(Swine swine) {
		this.swine = swine;
	}
	
}
