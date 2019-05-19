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

import com.frosters.model.Inventory;
import com.frosters.service.InventoryService;

@RestController
@RequestMapping("/item")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping()
	public ResponseEntity<List<Inventory>> getAllItemsService(){
		if (inventoryService.getAllItems().isEmpty())
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Inventory>>(inventoryService.getAllItems(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Inventory> getSpecificItemService(@PathVariable ("id") long skuId){
		if (inventoryService.getSpecificItem(skuId) != null)
			return new ResponseEntity<Inventory>(inventoryService.getSpecificItem(skuId), HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	public ResponseEntity<Inventory> addNewItemService(@RequestBody Inventory inventory){
		return new ResponseEntity<Inventory>(inventoryService.addNewItem(inventory), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Inventory> updateExistingItemService(@RequestBody Inventory inventory, @PathVariable ("id") long skuId){
		if (inventoryService.getSpecificItem(skuId) != null)
			return new ResponseEntity<Inventory>(inventoryService.updateExistingItem(inventory), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<HttpStatus> deleteSpecificItemService(@PathVariable ("id") long skuId){
		if (inventoryService.getSpecificItem(skuId) != null) {
			inventoryService.deleteSpecificItem(skuId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllItemsService(){
		inventoryService.deleteAllItems();
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
