package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.DailyMeals;

public interface DailyMealsService {
	
	public void createDailyMeal(DailyMeals meal);
	public void updateDailyMeal(DailyMeals meal);
	public void deleteDailyMeal(DailyMeals meal);
	
	public List<DailyMeals> getAllDailyMeals();
	public List<DailyMeals> getMealsByUser(String username);



}
