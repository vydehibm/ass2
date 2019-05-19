package com.frosters.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frosters.model.Vendor;
import com.frosters.repository.VendorRepository;

@Service
public class VendorService {

	@Autowired 
	private VendorRepository vendorRepository;
	public List<Vendor> getAllVendors(){
		return vendorRepository.findAll();
	}
	public Optional<Vendor> getSpevificVendor(long vendorId) {
		return vendorRepository.findById(vendorId);
	}
	public Vendor addNewVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	public Vendor updateExistingVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	public void deleteSpecificVendor(long vendorId) {
		vendorRepository.deleteById(vendorId);
	}
	public void deleteAllVendors() {
		vendorRepository.deleteAll();
	}
	
	
}
