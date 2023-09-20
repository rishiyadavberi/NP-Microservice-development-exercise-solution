package com.plan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long planId;
	private String name;
	private String cost;
	private String details;
	
	
	public Plan() {
		super();
	}


	public Plan(long planId, String name, String cost, String details) {
		super();
		this.planId = planId;
		this.name = name;
		this.cost = cost;
		this.details = details;
	}


	public long getPlanId() {
		return planId;
	}


	public void setPlanId(long planId) {
		this.planId = planId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", name=" + name + ", cost=" + cost + ", details=" + details + "]";
	}
	
	
	
	
}
