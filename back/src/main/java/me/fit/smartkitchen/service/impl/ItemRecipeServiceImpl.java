package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.ItemRecipe;
import me.fit.smartkitchen.service.api.ItemRecipeService;

@ApplicationScoped
public class ItemRecipeServiceImpl implements ItemRecipeService {
	@Inject
	EntityManager em;

	@Transactional
	public void createItemRecipe(ItemRecipe itemRecipe) {
		// TODO Auto-generated method stub
		em.persist(itemRecipe);
	}

	@Transactional
	public void updateItemRecipe(ItemRecipe itemRecipe) {
		// TODO Auto-generated method stub
		em.merge(itemRecipe);
		
	}

	@Transactional
	public void deleteItemRecipe(ItemRecipe itemRecipe) {
		// TODO Auto-generated method stub
		em.remove(em.contains(itemRecipe) ? itemRecipe : em.merge(itemRecipe));

	}

	@Transactional
	public List<ItemRecipe> getAllItemRecipes() {
		// TODO Auto-generated method stub
		List<ItemRecipe> itemRecipe = em.createNamedQuery(ItemRecipe.GET_ALL_ITEM_RECIPES, ItemRecipe.class).getResultList();
		return itemRecipe;
	}

}
