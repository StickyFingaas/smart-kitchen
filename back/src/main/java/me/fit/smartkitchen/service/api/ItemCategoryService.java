package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.ItemCategory;

public interface ItemCategoryService {

	public void createItemCategory(ItemCategory itemCategory);
	public void updateItemCategory(ItemCategory itemCategory);
	public void deleteItemCategory(ItemCategory itemCategory);
	public List<ItemCategory> getAllItemCategories();
	
}
