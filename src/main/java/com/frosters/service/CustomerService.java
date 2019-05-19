package com.frosters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frosters.model.Customer;
import com.frosters.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
}
