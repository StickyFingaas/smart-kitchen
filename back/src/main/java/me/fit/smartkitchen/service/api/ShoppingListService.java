package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.ShoppingList;

public interface ShoppingListService {

	public void createShoppingList(ShoppingList shoppingList);
	
	public void updateShoppingList(ShoppingList shoppingList);
	
	public void deleteShoppingList(ShoppingList shoppingList);

	public List<ShoppingList> getAllLists();
	
	public List<ShoppingList> getListsByUser(String username);

	
}
