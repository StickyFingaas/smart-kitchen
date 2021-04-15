package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.User;

public interface UserService {
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();

}
