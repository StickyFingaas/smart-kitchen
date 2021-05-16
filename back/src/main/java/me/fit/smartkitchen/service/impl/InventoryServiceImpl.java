package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.Inventory;
import me.fit.smartkitchen.service.api.InventoryService;
@ApplicationScoped
public class InventoryServiceImpl  implements InventoryService{

	@Inject
	EntityManager em;
	
	@Transactional
	public void createInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		em.persist(inventory);
	}

	@Transactional
	public void updateInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		em.merge(inventory);
	}
	@Transactional
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		List<Inventory> inventory = em.createNamedQuery(Inventory.GET_ALL_INVENTORIES, Inventory.class).getResultList();
		return inventory;
	}
	@Transactional
	public void deleteInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		em.remove(em.contains(inventory) ? inventory : em.merge(inventory));
	}

}
