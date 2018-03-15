package com.sims.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Feeding {

	@Id
	@GeneratedValue
	private long feedingID;
	
	private Date feedingDate;
	
	private Time feedingTime;
	
	private String foodType;
	
	private Double foodAmount;	
	
	@ManyToOne
	private Swine swine;
	
	@ManyToOne
	private Food food;
	
	public long getFeedingID() {
		return feedingID;
	}
	public void setFeedingID(long feedingID) {
		this.feedingID = feedingID;
	}
	
	public Date getFeedingDate() {
		return feedingDate;
	}
	public void setFeedingtDate(Date feedingDate) {
		this.feedingDate = feedingDate;
	}
	
	public Time getFeedingTime() {
		return feedingTime;
	}
	public void setFeedingtTime(Time feedingTime) {
		this.feedingTime = feedingTime;
	}
	
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public Double getFoodAmount() {
		return foodAmount;
	}
	public void setFoodAmount(Double foodAmount) {
		this.foodAmount = foodAmount;
	}
	
	public Swine getSwine() {
		return swine;
	}

	public void setSwine(Swine swine) {
		this.swine = swine;
	}
	
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
}
