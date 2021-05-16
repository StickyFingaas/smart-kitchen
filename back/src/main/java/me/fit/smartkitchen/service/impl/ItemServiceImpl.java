package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.Item;
import me.fit.smartkitchen.service.api.ItemService;

@ApplicationScoped
public class ItemServiceImpl implements ItemService {

	@Inject
	EntityManager em;

	@Transactional
	public void createItem(Item item) {
		em.persist(item);
	}

	@Transactional
	public void updateItem(Item item) {
		em.merge(item);
	}

	@Transactional
	public void deleteItem(Item item) {
		em.remove(em.contains(item) ? item : em.merge(item));

	}

	@Transactional
	public List<Item> getAllItems() {
		List<Item> items = em.createNamedQuery(Item.GET_ALL_ITEMS, Item.class).getResultList();
		return items;
	}

}
