package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.ShoppingListItem;
import me.fit.smartkitchen.service.api.ShoppingListItemService;

@ApplicationScoped
public class ShoppingListItemServiceImpl implements ShoppingListItemService {
	
	@Inject
	EntityManager em;

	@Transactional
	public void createShoppingListItem(ShoppingListItem shoppingListItem) {
		// TODO Auto-generated method stub
		em.persist(shoppingListItem);
	}

	@Transactional
	public void updateShoppingListItem(ShoppingListItem shoppingListItem) {
		// TODO Auto-generated method stub
		em.merge(shoppingListItem);
	}

	@Transactional
	public void deleteShoppingListItem(ShoppingListItem shoppingListItem) {
		// TODO Auto-generated method stub
		em.remove(shoppingListItem);
	}

	@Transactional
	public List<ShoppingListItem> getAllShoppingListItems() {
		// TODO Auto-generated method stub
		List<ShoppingListItem> shoppingListItem = em.createNamedQuery(ShoppingListItem.GET_ALL_SHOPPING_LIST_ITEMS, ShoppingListItem.class).getResultList();
		return shoppingListItem;
	}

}
