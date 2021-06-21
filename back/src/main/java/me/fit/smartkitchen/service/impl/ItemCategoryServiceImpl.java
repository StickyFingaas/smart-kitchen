package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.ItemCategory;
import me.fit.smartkitchen.service.api.ItemCategoryService;

@ApplicationScoped
public class ItemCategoryServiceImpl implements ItemCategoryService{

	@Inject
	EntityManager em;
	
	@Transactional
	public void createItemCategory(ItemCategory itemCategory) {
		// TODO Auto-generated method stub
		em.persist(itemCategory);
	}

	@Transactional
	public void updateItemCategory(ItemCategory itemCategory) {
		// TODO Auto-generated method stub
		em.merge(itemCategory);
	}

	@Transactional
	public void deleteItemCategory(ItemCategory itemCategory) {
		// TODO Auto-generated method stub
		em.remove(em.contains(itemCategory) ? itemCategory : em.merge(itemCategory));
	}

	@Transactional
	public List<ItemCategory> getAllItemCategories() {
		// TODO Auto-generated method stub
		List<ItemCategory> itemCategory = em.createNamedQuery(ItemCategory.GET_ALL_CATEGORY_ITEMS, ItemCategory.class).getResultList();
		return itemCategory;
	}

}
