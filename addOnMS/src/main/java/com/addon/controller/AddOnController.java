package com.addon.controller;

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

import com.addon.model.AddOn;
import com.addon.service.IAddOnService;


@RestController
@RequestMapping("/api/addOn")
public class AddOnController {
	
	@Autowired
	private IAddOnService addOnService;
	
	@PostMapping("/addAddOn")
	public ResponseEntity<?> addAddOnHandler(@RequestBody AddOn aObj){
		AddOn newAddOn = this.addOnService.addAddOn(aObj);
		return new ResponseEntity<>(newAddOn,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllAddOns")
	public ResponseEntity<?> getAllAddOnsHandler(){
		List<AddOn> allAddOns = this.addOnService.getAllAddOns();
		return new ResponseEntity<>(allAddOns,HttpStatus.OK);
	}

	@GetMapping("/getAddOnsByFeatureName/{featureName}")
	public ResponseEntity<?> getAddOnsByFeatureNameHandler(@PathVariable String featureName){
		List<AddOn> addOns = this.addOnService.getAddOnsByFeatureName(featureName);
		return new ResponseEntity<>(addOns,HttpStatus.OK);
	}
	
	@GetMapping("/getAddOnsByCost/{cost}")
	public ResponseEntity<?> getAddOnsByCosteHandler(@PathVariable String cost){
		List<AddOn> plans = this.addOnService.getAddOnsByCost(cost);
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/getAddOnsById/{addOnId}")
	public ResponseEntity<?> getAddOnsByIdHandler(@PathVariable long addOnId){
		AddOn addOn = this.addOnService.getPlanById(addOnId);
		return new ResponseEntity<>(addOn,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{addOnId}")
	public ResponseEntity<?> deleteAddOnByIdHandler(@PathVariable long addOnId){
		boolean status = this.addOnService.deleteAddOn(addOnId);
		if(status) {
			return new ResponseEntity<>("User Deleted Successfully..",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateAddOn/{addOnId}")
	public ResponseEntity<?> updateAddonrHandler(@RequestBody AddOn aObj,@PathVariable long addOnId){
		AddOn updatedPlan = this.addOnService.updateAddOn(aObj, addOnId);
		return new ResponseEntity<>(updatedPlan,HttpStatus.CREATED);
	}
}
