package com.frosters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frosters.model.Vendor;
import com.frosters.service.VendorService;

@RestController
@RequestMapping("/vendor/")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping()
	public ResponseEntity<List<Vendor>> getAllVendorsService(){
		if(vendorService.getAllVendors().isEmpty())
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<>(vendorService.getAllVendors(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Vendor> getSpecificVendorService(@PathVariable ("id") long vendorId) {
		if (vendorService.getSpevificVendor(vendorId).isPresent())
			return new ResponseEntity<Vendor>(vendorService.getSpevificVendor(vendorId).get(), HttpStatus.OK) ;
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	public ResponseEntity<Vendor> addNewVendorService(@RequestBody Vendor vendor){
		return new ResponseEntity<Vendor>(vendorService.addNewVendor(vendor), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Vendor> updateExistingVendorService(@RequestBody Vendor vendor, @PathVariable ("id") long vendorId){
		if (vendorService.getSpevificVendor(vendorId).isPresent())
			return new ResponseEntity<Vendor>(vendorService.updateExistingVendor(vendor), HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<HttpStatus> deleteSpecificVendorService(@PathVariable ("id") long vendorId){
		if (vendorService.getSpevificVendor(vendorId).isPresent()) {
			vendorService.deleteSpecificVendor(vendorId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping()
	public ResponseEntity<HttpStatus> deleteAllVendorsService(){
		vendorService.deleteAllVendors();
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
