package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.KitchenUser;
import me.fit.smartkitchen.service.api.KitchenUserService;

@ApplicationScoped
public class KitchenUserServiceImpl implements KitchenUserService{
	
	@Inject
	EntityManager em;

	@Transactional
	public void createKitchenUser(KitchenUser user) {
		em.persist(user);
	}
	
	@Transactional
	public void updateKitchenUser(KitchenUser user) {
		em.merge(user);
	}
	
	@Transactional
	public List<KitchenUser> getAllKitchenUser() {
		List<KitchenUser> users = em.createNamedQuery(KitchenUser.GET_ALL_KITCHEN_USERS, KitchenUser.class).getResultList();
		return users;
	}

}
