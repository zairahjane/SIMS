package com.sims.domain;

import javax.persistence.GeneratedValue;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Swine {

	@Id
	@GeneratedValue
	private Long swineID;
	
	private String type;
	
	private String breed;

	private String gender;
	
	private Date bday;
	
	private String description;
		
	
	public Long getSwineID() {
		return swineID;
	}
	public void setSwineID(Long swineID) {
		this.swineID = swineID;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
