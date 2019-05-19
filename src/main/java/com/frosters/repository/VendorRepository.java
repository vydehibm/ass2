package com.frosters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frosters.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
