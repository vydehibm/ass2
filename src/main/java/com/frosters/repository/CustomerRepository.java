package com.frosters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frosters.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//public List<Customer> find();
	
}
