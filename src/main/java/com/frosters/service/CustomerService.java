package com.frosters.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//.isPresent() ? customerService.getSpecificCustomer(customerId).get() : null;
	public ResponseEntity<Customer> getSpecificCustomer(long customerId) {
		if (customerRepository.findById(customerId).isPresent())
			return new ResponseEntity<>(customerRepository.findById(customerId).get(), HttpStatus.OK);
		else
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public ResponseEntity<Customer> updateExistingCustomer(Customer customer, long customerId) {
		if (customerRepository.findById(customerId).isPresent())
			return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
		else
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<HttpStatus> deleteSpecificCustomer(long customerId) {
		if (customerRepository.findById(customerId).isPresent()){
			customerRepository.deleteById(customerId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		customerRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}



}
