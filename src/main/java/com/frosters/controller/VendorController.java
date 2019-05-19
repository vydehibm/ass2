package com.frosters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.frosters.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	
}
