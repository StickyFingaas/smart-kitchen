package me.fit.smartkitchen.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.smartkitchen.model.User;
import me.fit.smartkitchen.service.api.UserService;

@ApplicationScoped
public class UserServiceImpl implements UserService{
	
	@Inject
	EntityManager em;

	@Transactional
	public void createUser(User user) {
		em.persist(user);
	}
	
	@Transactional
	public void updateUser(User user) {
		em.merge(user);
	}
	
	@Transactional
	public List<User> getAllUsers() {
		List<User> users = em.createNamedQuery(User.GET_ALL_USERS, User.class).getResultList();
		return users;
	}

}
