package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.ItemRecipe;

public interface ItemRecipeService {

	public void createItemRecipe(ItemRecipe itemRecipe);
	public void updateItemRecipe(ItemRecipe itemRecipe);
	public void deleteItemRecipe(ItemRecipe itemRecipe);
	public List<ItemRecipe> getAllItemRecipes();

}
