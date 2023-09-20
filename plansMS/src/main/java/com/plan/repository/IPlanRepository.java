package com.plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plan.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {
	
	public List<Plan> findByName(String name);
	public List<Plan> findByCost(String cost);
	public List<Plan> findByDetails(String details);

}
