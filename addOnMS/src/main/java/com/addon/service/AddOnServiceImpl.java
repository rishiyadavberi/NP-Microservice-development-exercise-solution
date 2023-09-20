package com.addon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addon.model.AddOn;
import com.addon.repository.IAddOnRepositoryt;



@Service
public class AddOnServiceImpl implements IAddOnService {

	@Autowired
	private IAddOnRepositoryt repo;
	@Override
	public AddOn addAddOn(AddOn aObj) {
		Optional<AddOn> optional = this.repo.findById(aObj.getAddOnId());
		if(optional.isPresent()) {
			System.out.println("AddOn already exists");
		}
		AddOn addAddOn = this.repo.save(aObj);
		return addAddOn;
	}

	@Override
	public boolean deleteAddOn(long addOnId) {
		Optional<AddOn> optional = this.repo.findById(addOnId);
		boolean status = false;
		if(optional.isPresent()) {
			this.repo.delete(optional.get());
			status = true;
		}else {
			System.out.println("AddOn doesn't exist");
		}
		return status;
	}

	@Override
	public AddOn updateAddOn(AddOn aObj, long addOnId) {
		Optional<AddOn> optional = this.repo.findById(addOnId);
		AddOn AObj = null;
		AddOn updatedData = null;
		
		if(optional.isPresent()) {
			AObj = optional.get();
			AObj.setCost(aObj.getCost());
			AObj.setFeatureName(aObj.getFeatureName());
			updatedData = this.repo.save(AObj);
		}
		return updatedData;
	}

	@Override
	public AddOn getPlanById(long addOnId) {
		Optional<AddOn> optional = this.repo.findById(addOnId);
		
		AddOn aObj = null;
		if(optional.isPresent()) {
			System.out.println("AddOn Found");
			aObj = optional.get();
		}else {
			System.out.println("AddOn doesn't exists");
		}
		return aObj;
	}

	@Override
	public List<AddOn> getAllAddOns() {
		return this.repo.findAll();
	}

	@Override
	public List<AddOn> getAddOnsByFeatureName(String featureName) {
		List<AddOn> addOns = this.repo.findByFeatureName(featureName);
		return addOns;
	}

	@Override
	public List<AddOn> getAddOnsByCost(String cost) {
		List<AddOn> addOns = this.repo.findByCost(cost);
		return addOns;
	}


}
