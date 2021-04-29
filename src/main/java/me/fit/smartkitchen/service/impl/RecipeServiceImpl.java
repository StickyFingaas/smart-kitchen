package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.Recipe;
import me.fit.smartkitchen.service.api.RecipeService;
@ApplicationScoped
public class RecipeServiceImpl  implements RecipeService{

	@Inject
	EntityManager em;
	
	@Transactional
	public void createRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		em.persist(recipe);
	}

	@Transactional
	public void updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		em.merge(recipe);
	}
	@Transactional
	public List<Recipe> getAllRecipe() {
		// TODO Auto-generated method stub
		List<Recipe> recipe = em.createNamedQuery(Recipe.GET_ALL_RECIPE, Recipe.class).getResultList();
		return recipe;
	}
	@Transactional
	public void deleteRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		em.remove(em.contains(recipe) ? recipe : em.merge(recipe));
	}

}
