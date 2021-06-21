package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.DailyMealsRecipe;
import me.fit.smartkitchen.service.api.DailyMealsRecipeService;

@ApplicationScoped
public class DailyMealsRecipeServiceImpl implements DailyMealsRecipeService{

	@Inject
	EntityManager em;
	
	@Transactional
	public void createDailyMealsRecipe(DailyMealsRecipe dailyMealsRecipe) {
		// TODO Auto-generated method stub
		em.persist(dailyMealsRecipe);
	}

	@Transactional
	public void updateDailyMealsRecipe(DailyMealsRecipe dailyMealsRecipe) {
		// TODO Auto-generated method stub
		em.merge(dailyMealsRecipe);
	}

	@Transactional
	public void deleteDailyMealsRecipe(DailyMealsRecipe dailyMealsRecipe) {
		// TODO Auto-generated method stub
		em.remove(em.contains(dailyMealsRecipe) ? dailyMealsRecipe : em.merge(dailyMealsRecipe));
	}

	@Transactional
	public List<DailyMealsRecipe> getDailyMealsRecipes() {
		// TODO Auto-generated method stub
		List<DailyMealsRecipe> dailyMealsRecipe = em.createNamedQuery(DailyMealsRecipe.GET_ALL_DAILYMEALS_RECIPES, DailyMealsRecipe.class).getResultList();
		return dailyMealsRecipe;
	}

}
