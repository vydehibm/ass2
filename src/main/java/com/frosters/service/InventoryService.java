package com.frosters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frosters.model.Inventory;
import com.frosters.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public List<Inventory> getAllItems() {
		return inventoryRepository.findAll();		
	}

	public Inventory getSpecificItem(long skuId) {
		return inventoryRepository.getOne(skuId);
	}

	public Inventory addNewItem(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	public Inventory updateExistingItem(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	public void deleteSpecificItem(long skuId) {
		inventoryRepository.deleteById(skuId);
	}

	public void deleteAllItems() {
		inventoryRepository.deleteAll();	
	}
	
	
}
