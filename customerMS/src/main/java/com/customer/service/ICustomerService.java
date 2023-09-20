package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.model.Customer;

@Service
public interface ICustomerService {
	
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(long customerId, Customer customer);
	public boolean deleteCustomer(long customerId);
	public Customer selectPlan(long customerId, Customer customer);
	public Customer addAddOns(long customerId, Customer customer);
	public Customer removeAddOns(long customerId, Customer customer);
	public List<Customer> getAll();

}
