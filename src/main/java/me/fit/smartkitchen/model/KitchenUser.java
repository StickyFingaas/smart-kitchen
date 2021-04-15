package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({ @NamedQuery(name = KitchenUser.GET_ALL_KITCHEN_USERS, query = "Select s from KitchenUser s"),
		@NamedQuery(name = KitchenUser.GET_KITCHEN_USERS_BY_NAME, query = "Select s from KitchenUser s where s.username = :username") })
public class KitchenUser {

	public static final String GET_ALL_KITCHEN_USERS = "KitchenUser.getAllKitchenUsers";
	public static final String GET_KITCHEN_USERS_BY_NAME = "KitchenUser.getKitchenUsersByName";

	@Id
	@SequenceGenerator(name = "kitchenUserSequence", sequenceName = "kitchen_user_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "kitchenUserSequence")
	private Long id;
	private String username;
	private String password;
	private String email;
	@OneToOne
	private Inventory inventory;
	@OneToMany
	private Set<ShoppingList> shoppingLists;
	@OneToMany
	private Set<FoodPlan> foodPlans;

	public KitchenUser() {
		super();
	}

	public KitchenUser(Long id, String username, String password, String email, Inventory inventory,
			Set<ShoppingList> shoppingLists, Set<FoodPlan> foodPlans) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.inventory = inventory;
		this.shoppingLists = shoppingLists;
		this.foodPlans = foodPlans;
	}

	public KitchenUser(String username, String password, String email, Inventory inventory, Set<ShoppingList> shoppingLists,
			Set<FoodPlan> foodPlans) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.inventory = inventory;
		this.shoppingLists = shoppingLists;
		this.foodPlans = foodPlans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Set<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}

	public void setShoppingLists(Set<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}

	public Set<FoodPlan> getFoodPlans() {
		return foodPlans;
	}

	public void setFoodPlans(Set<FoodPlan> foodPlans) {
		this.foodPlans = foodPlans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KitchenUser other = (KitchenUser) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", inventory=" + inventory + ", shoppingLists=" + shoppingLists + ", foodPlans=" + foodPlans + "]";
	}
}
