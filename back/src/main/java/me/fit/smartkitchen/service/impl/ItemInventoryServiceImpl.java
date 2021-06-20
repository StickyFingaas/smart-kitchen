package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.ItemInventory;
import me.fit.smartkitchen.service.api.ItemInventoryService;
@ApplicationScoped
public class ItemInventoryServiceImpl implements ItemInventoryService {
	
	@Inject
	EntityManager em;

	@Transactional
	public void createItemInventory(ItemInventory itemInventory) {
		// TODO Auto-generated method stub
		em.persist(itemInventory);
	}

	@Transactional
	public void updateItemInventory(ItemInventory itemInventory) {
		// TODO Auto-generated method stub
		em.merge(itemInventory);
	}

	@Transactional
	public void deleteItemInventory(ItemInventory itemInventory) {
		// TODO Auto-generated method stub
		em.remove(em.contains(itemInventory) ? itemInventory : em.merge(itemInventory));
	}

	@Transactional
	public List<ItemInventory> getAllItemInventories() {
		// TODO Auto-generated method stub
		List<ItemInventory> itemInventory = em.createNamedQuery(ItemInventory.GET_ALL_ITEM_INVENTORIES, ItemInventory.class).getResultList();
		return itemInventory;
	}

}
