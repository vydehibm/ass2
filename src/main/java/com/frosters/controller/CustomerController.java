package com.frosters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getAllCustomersService(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(path = "/{id}")
	public Customer getSpecificCustomerService(@PathVariable("id") long customerId) {
		return customerService.getSpecificCustomer(customerId).isPresent() ? customerService.getSpecificCustomer(customerId).get() : null;
	}
	
}
