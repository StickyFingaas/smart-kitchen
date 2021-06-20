package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.Item;

public interface ItemService {

	public void createItem(Item item);

	public void updateItem(Item item);
	
	public void deleteItem(Long id);

	public List<Item> getAllItems();

}
