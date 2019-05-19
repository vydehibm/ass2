package com.frosters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frosters.model.Customer;
import com.frosters.service.CustomerService;

@RestController
@RequestMapping (value = "/customer/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomersService(){

		if (customerService.getAllCustomers().size() > 0)
			return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}")
	public Customer getSpecificCustomerService(@PathVariable("id") long customerId) {
		return customerService.getSpecificCustomer(customerId).isPresent() ? customerService.getSpecificCustomer(customerId).get() : null;
	}
	





}
