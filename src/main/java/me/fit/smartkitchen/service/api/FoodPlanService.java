package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.FoodPlan;

public interface FoodPlanService {

	public void createFoodPlan(FoodPlan foodPlan);

	public void updateFoodPlan(FoodPlan foodPlan);
	
	public void destroyFoodPlan(FoodPlan foodPlan);

	public List<FoodPlan> getAllFoodPlans();
}
