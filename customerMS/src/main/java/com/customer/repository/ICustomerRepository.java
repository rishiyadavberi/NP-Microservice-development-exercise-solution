package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
