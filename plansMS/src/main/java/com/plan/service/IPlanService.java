package com.plan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plan.model.Plan;

@Service
public interface IPlanService {
	
	public Plan addPlan(Plan pObj);
	public boolean deletePlan(long pId);
	public Plan updatePlan(Plan pObj, long pId);
	public Plan getPlanById(long pId);
	public List<Plan> getAllPlans();
	public List<Plan> getPlansByName(String name);
	public List<Plan> getPlansByCost(String cost);
	public List<Plan> getPlansByDetails(String details);
	

}
