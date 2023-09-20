package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        boolean deleted = customerService.deleteCustomer(customerId);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PatchMapping("/addSelectedPlan/{customerId}")
    public ResponseEntity<Customer> selectedPlanHandler(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updated = customerService.selectPlan(customerId, customer);
        return new ResponseEntity<>(updated,HttpStatus.NOT_FOUND);
        
    }
	
	
	@PatchMapping("/addAddOns/{customerId}")
    public ResponseEntity<Customer> addAddOnHandler(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updated = customerService.addAddOns(customerId, customer);
        if (updated == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllHandler(){
		List<Customer> all = this.customerService.getAll();
		return new ResponseEntity<>(all,HttpStatus.OK);
		
	}
	
	@PostMapping("/removeAddOns/{customerId}")
    public ResponseEntity<Customer> removeAddOnsHandler(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.removeAddOns(customerId, customer);

        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
