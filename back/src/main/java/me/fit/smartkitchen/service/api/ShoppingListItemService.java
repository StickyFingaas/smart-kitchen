package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.ShoppingListItem;

public interface ShoppingListItemService {
	
	public void createShoppingListItem(ShoppingListItem shoppingListItem);
	public void updateShoppingListItem(ShoppingListItem shoppingListItem);
	public void deleteShoppingListItem(ShoppingListItem shoppingListItem);
	public List<ShoppingListItem> getAllShoppingListItems();

}
