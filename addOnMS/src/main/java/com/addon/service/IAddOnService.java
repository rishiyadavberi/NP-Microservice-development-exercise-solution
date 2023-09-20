package com.addon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.addon.model.AddOn;



public interface IAddOnService {
	public AddOn addAddOn(AddOn aObj);
	public boolean deleteAddOn(long addOnId);
	public AddOn updateAddOn(AddOn aObj, long addOnId);
	public AddOn getPlanById(long addOnId);
	public List<AddOn> getAllAddOns();
	public List<AddOn> getAddOnsByFeatureName(String featureName);
	public List<AddOn> getAddOnsByCost(String cost);

}
