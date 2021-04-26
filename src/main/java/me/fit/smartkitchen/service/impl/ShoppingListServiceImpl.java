package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.Item;
import me.fit.smartkitchen.model.KitchenUser;
import me.fit.smartkitchen.model.ShoppingList;
import me.fit.smartkitchen.service.api.ShoppingListService;

@ApplicationScoped
public class ShoppingListServiceImpl implements ShoppingListService {

	@Inject
	EntityManager em;

	@Transactional
	public void createShoppingList(ShoppingList shoppingList) {
		em.persist(shoppingList);

	}

	@Transactional
	public void updateShoppingList(ShoppingList shoppingList) {
		em.merge(shoppingList);

	}

	@Transactional
	public void deleteShoppingList(ShoppingList shoppingList) {
		em.remove(shoppingList);
	}

	@Transactional
	public List<ShoppingList> getAllLists() {
		List<ShoppingList> lists = em.createNamedQuery(ShoppingList.GET_ALL_LISTS, ShoppingList.class).getResultList();
		return lists;
	}

	@Transactional
	public List<ShoppingList> getListsByUser(String name) {
		List<ShoppingList> lists = em.createNamedQuery(ShoppingList.GET_LISTS_BY_USER, ShoppingList.class)
				.setParameter("kitchenUser", name).getResultList();
		return lists;
	}

}
