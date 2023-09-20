package com.plan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan.model.Plan;
import com.plan.repository.IPlanRepository;

@Service
public class PlanServiceImpl implements IPlanService {
	
	@Autowired
	private IPlanRepository repo;

	@Override
	public Plan addPlan(Plan pObj) {
		Optional<Plan> optional = this.repo.findById(pObj.getPlanId());
		if(optional.isPresent()) {
			System.out.println("Plan already exists");
		}
		Plan addPlan = this.repo.save(pObj);
		return addPlan;
	}

	@Override
	public boolean deletePlan(long pId) {
		Optional<Plan> optional = this.repo.findById(pId);
		boolean status = false;
		if(optional.isPresent()) {
			this.repo.delete(optional.get());
			status = true;
		}else {
			System.out.println("Plan doesn't exist");
		}
		return status;
	}

	@Override
	public Plan updatePlan(Plan pObj, long pId) {
		Optional<Plan> optional = this.repo.findById(pId);
		Plan PObj = null;
		Plan updatedData = null;
		
		if(optional.isPresent()) {
			PObj = optional.get();
			PObj.setCost(pObj.getCost());
			PObj.setName(pObj.getName());
			PObj.setDetails(pObj.getDetails());
			updatedData = this.repo.save(PObj);
		}
		return updatedData;
	}

	@Override
	public Plan getPlanById(long pId) {
		Optional<Plan> optional = this.repo.findById(pId);
		
		Plan pObj = null;
		if(optional.isPresent()) {
			System.out.println("Plan Found");
			pObj = optional.get();
		}else {
			System.out.println("Plan doesn't exists");
		}
		return pObj;
	}

	@Override
	public List<Plan> getAllPlans() {
		return this.repo.findAll();
	}

	@Override
	public List<Plan> getPlansByName(String name) {
		List<Plan> plans = this.repo.findByName(name);
		return plans;
	}

	@Override
	public List<Plan> getPlansByCost(String cost) {
		List<Plan> plans = this.repo.findByCost(cost);
		return plans;
	}

	@Override
	public List<Plan> getPlansByDetails(String details) {
		List<Plan> plans = this.repo.findByDetails(details);
		return plans;
	}

}
