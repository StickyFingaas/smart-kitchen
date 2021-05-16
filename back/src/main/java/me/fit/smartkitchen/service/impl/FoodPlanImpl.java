package me.fit.smartkitchen.service.impl;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import me.fit.smartkitchen.model.FoodPlan;
import me.fit.smartkitchen.service.api.FoodPlanService;

@ApplicationScoped
public class FoodPlanImpl implements FoodPlanService{

	@Inject
	EntityManager em;

	@Transactional
	public void createFoodPlan(FoodPlan foodPlan) {
		em.persist(foodPlan);
	}

	@Transactional
	public void updateFoodPlan(FoodPlan foodPlan) {
		em.merge(foodPlan);
	}
	
	@Transactional
	public void destroyFoodPlan(FoodPlan foodPlan) {
		em.remove(em.contains(foodPlan) ? foodPlan : em.merge(foodPlan));
	}

	@Transactional
	public List<FoodPlan> getAllFoodPlans() {
		List<FoodPlan> foodPlans = em.createNamedQuery(FoodPlan.GET_ALL_FOOD_PLANS, FoodPlan.class).getResultList();
		return foodPlans;
	}
}
