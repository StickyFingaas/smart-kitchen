package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.DailyMeals;
import me.fit.smartkitchen.service.api.DailyMealsService;

@ApplicationScoped
public class DailyMealsServiceImpl implements DailyMealsService{
	
	@Inject
	EntityManager em;

	@Transactional
	public void createDailyMeal(DailyMeals meal) {
		em.persist(meal);
		
	}

	@Transactional
	public void updateDailyMeal(DailyMeals meal) {
		em.merge(meal);
		
	}

	@Transactional
	public void deleteDailyMeal(DailyMeals meal) {
		em.remove(em.contains(meal) ? meal : em.merge(meal));
		
	}

	@Transactional
	public List<DailyMeals> getAllDailyMeals() {
		List<DailyMeals> meals = em.createNamedQuery(DailyMeals.GET_ALL_MEALS, DailyMeals.class).getResultList();
		return meals;
	}

	@Transactional
	public List<DailyMeals> getMealsByUser(String username) {
		List<DailyMeals> meals = em.createNamedQuery(DailyMeals.GET_MEALS_BY_USER, DailyMeals.class)
				.setParameter("kitchenUser", username).getResultList();
		return meals;
	}

	
	

}
