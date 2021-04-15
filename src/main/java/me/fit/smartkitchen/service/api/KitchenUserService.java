package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.KitchenUser;

public interface KitchenUserService {
	
	public void createKitchenUser(KitchenUser user);
	
	public void updateKitchenUser(KitchenUser user);
	
	public List<KitchenUser> getAllKitchenUser();

}