package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.DailyMealsRecipe;


public interface DailyMealsRecipeService {

	public void createDailyMealsRecipe(DailyMealsRecipe dailyMealsRecipe);
	public void updateDailyMealsRecipe(DailyMealsRecipe dailyMealsRecipe);
	public void deleteDailyMealsRecipe(DailyMealsRecipe dailyMealsRecipe);
	public List<DailyMealsRecipe> getDailyMealsRecipes();
}
