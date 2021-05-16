package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.Inventory;

public interface InventoryService {
	
	public void createInventory(Inventory inventory);
	public void updateInventory(Inventory inventory);
	public void deleteInventory(Inventory inventory);
	public List<Inventory> getAllInventory();

}