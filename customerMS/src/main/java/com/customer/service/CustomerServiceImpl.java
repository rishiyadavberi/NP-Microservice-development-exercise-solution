package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		Optional<Customer> optional = this.repo.findById(customer.getCutomerId());
		if(optional.isPresent()) {
			return null;
		}else {
			return this.repo.save(customer);
		}
	}

	@Override
	public Customer updateCustomer(long customerId, Customer updatedCustomer) {
		Optional<Customer> optionalCustomer = this.repo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setCustomerName(updatedCustomer.getCustomerName());
            customer.setCustomerPhoneNo(updatedCustomer.getCustomerPhoneNo());
            customer.setSelectedPlanId(updatedCustomer.getSelectedPlanId());
            customer.setSelectedAddOnsIds(updatedCustomer.getSelectedAddOnsIds());
            return this.repo.save(customer);
        }

        return null;
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		Optional<Customer> optional = this.repo.findById(customerId);
		boolean status = false;
		if(optional.isPresent()) {
			this.repo.delete(optional.get());
			status = true;
		}else {
			System.out.println("Customer doesn't exist");
		}
		return status;
	}

	@Override
	public Customer selectPlan(long customerId, Customer customerToSelect) {
		Optional<Customer> optionalCustomer = this.repo.findById(customerId);
		Customer updated = null;
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setSelectedPlanId(customerToSelect.getSelectedPlanId());
            updated = this.repo.save(customer);
        }
        return updated;

        
	}

	@Override
	public Customer addAddOns(long customerId, Customer customerToAdd) {
		Optional<Customer> optionalCustomer = this.repo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setSelectedAddOnsIds(customerToAdd.getSelectedAddOnsIds());
            return this.repo.save(customer);
        }

        return null; // Customer not found
	}

	@Override
	public Customer removeAddOns(long customerId, Customer customerToRemove) {
		Customer customer = this.repo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Remove selected add-ons
        customer.getSelectedAddOnsIds().removeAll(customerToRemove.getSelectedAddOnsIds());

        // Save the updated customer
        return this.repo.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		return this.repo.findAll();
	}

}
