package com.addon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddOn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long addOnId;
	private String featureName;
	private String cost;
	public AddOn() {
		super();
	}
	public AddOn(long addOnId, String featureName, String cost) {
		super();
		this.addOnId = addOnId;
		this.featureName = featureName;
		this.cost = cost;
	}
	public long getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(long addOnId) {
		this.addOnId = addOnId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "AddOn [addOnId=" + addOnId + ", featureName=" + featureName + ", cost=" + cost + "]";
	}

	
}
