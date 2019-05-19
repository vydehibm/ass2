package com.frosters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.frosters.model.Customer;
import com.frosters.service.CustomerService;

@RestController
@RequestMapping (value = "/customer/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomersService(){

		if (customerService.getAllCustomers().size() > 0)
			return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}")
	public ResponseEntity<Customer> getSpecificCustomerService(@PathVariable("id") long customerId) {
		return customerService.getSpecificCustomer(customerId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Customer> addCustomerService(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateExistingCustomerService(@RequestBody Customer customer, @PathVariable("id") long customerId) {
		return customerService.updateExistingCustomer(customer, customerId);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteSpecificCustomer(@PathVariable("id") long customerId){
		return customerService.deleteSpecificCustomer(customerId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteAllCustomersService(){
		return customerService.deleteAllCustomers();
	}
	
}
