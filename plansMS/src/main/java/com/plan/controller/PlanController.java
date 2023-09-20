package com.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plan.model.Plan;
import com.plan.service.IPlanService;

@RestController
@RequestMapping("api/plan")
public class PlanController {

	@Autowired
	private IPlanService planService;
	
	
	@PostMapping("/addPlan")
	public ResponseEntity<?> addPlanHandler(@RequestBody Plan pObj){
		Plan newPlan = this.planService.addPlan(pObj);
		return new ResponseEntity<>(newPlan,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPlans")
	public ResponseEntity<?> getAllPlansHandler(){
		List<Plan> allPlans = this.planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/getPlansByName/{name}")
	public ResponseEntity<?> getPlansByNameHandler(@PathVariable String name){
		List<Plan> plans = this.planService.getPlansByName(name);
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/getPlansByCost/{cost}")
	public ResponseEntity<?> getPlansByCosteHandler(@PathVariable String cost){
		List<Plan> plans = this.planService.getPlansByCost(cost);
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/getPlansByDetails/{details}")
	public ResponseEntity<?> getPlansByDetailsHandler(@PathVariable String details){
		List<Plan> plans = this.planService.getPlansByDetails(details);
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/getPlansById/{pId}")
	public ResponseEntity<?> getPlansByIdHandler(@PathVariable long pId){
		Plan plan = this.planService.getPlanById(pId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{pId}")
	public ResponseEntity<?> deletePlanByIdHandler(@PathVariable long pId){
		boolean status = this.planService.deletePlan(pId);
		if(status) {
			return new ResponseEntity<>("User Deleted Successfully..",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updatePlan/{pId}")
	public ResponseEntity<?> updateUserHandler(@RequestBody Plan pObj,@PathVariable long pId){
		Plan updatedPlan = this.planService.updatePlan(pObj, pId);
		return new ResponseEntity<>(updatedPlan,HttpStatus.CREATED);
	}
}
