package me.fit.smartkitchen.service.api;

import java.util.List;

import me.fit.smartkitchen.model.KitchenUser;

public interface KitchenUserService {

	public void createKitchenUser(KitchenUser user);

	public void updateKitchenUser(KitchenUser user);
	
	public void deleteKitchenUserByID(Long id);

	public List<KitchenUser> getAllKitchenUsers();

	public List<KitchenUser> getKitchenUsersByID(Long id);

}
