package com.sims.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pregnancy {

	@Id
	@GeneratedValue
	private long pregnancyID;
	
	private Date pregnancyDate;	
	
	@ManyToOne
	private Swine swine;
	
	public long getPregnancyID() {
		return pregnancyID;
	}
	public void setPregnancytID(long pregnancyID) {
		this.pregnancyID = pregnancyID;
	}
	
	public Date getPregnancyDate() {
		return pregnancyDate;
	}
	public void setPregnancyDate(Date pregnancyDate) {
		this.pregnancyDate = pregnancyDate;
	}
	
	public Swine getSwine() {
		return swine;
	}

	public void setSwine(Swine swine) {
		this.swine = swine;
	}
	
}
