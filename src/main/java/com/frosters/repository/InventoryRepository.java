package com.frosters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frosters.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
