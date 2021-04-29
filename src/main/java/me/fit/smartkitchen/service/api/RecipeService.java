package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.Recipe;

public interface RecipeService {
	
	public void createRecipe(Recipe recipe);
	public void updateRecipe(Recipe recipe);
	public void deleteRecipe(Recipe recipe);
	public List<Recipe> getAllRecipe();

}
