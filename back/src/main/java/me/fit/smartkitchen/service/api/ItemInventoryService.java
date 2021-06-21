package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.ItemInventory;

public interface ItemInventoryService {

	public void createItemInventory(ItemInventory itemInventory);
	public void updateItemInventory(ItemInventory itemInventory);
	public void deleteItemInventory(ItemInventory itemInventory);
	public List<ItemInventory> getAllItemInventories();
	
}
