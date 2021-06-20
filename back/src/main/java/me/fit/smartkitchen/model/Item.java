package me.fit.smartkitchen.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({
	@NamedQuery(name = Item.GET_ALL_ITEMS, query = "Select i from Item i"),
	@NamedQuery(name = Item.GET_ITEM_BY_ID, query = "Select i from Item i where i.id = :id")
})
public class Item {
	
	public static final String GET_ALL_ITEMS = "getAllItems";
	public static final String GET_ITEM_BY_ID = "getItemById";

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private Long id;
	private String name;
	private Date expiryDate;
	private double price;
	private double discount;
	private String condition;
	@OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
	private Set<ItemCategory> categories;
	@OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<ShoppingListItem> shoppingLists;
	@OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
	private Set<ItemRecipe> recipes;
	@OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<ItemInventory> inventories;

	public Item() {
		super();
	}

	public Item(Long id, String name, Date expiryDate, double price, double discount, String condition,
			Set<ItemCategory> categories, Set<ShoppingListItem> shoppingLists, Set<ItemRecipe> recipes,
			Set<ItemInventory> inventories) {
		super();
		this.id = id;
		this.name = name;
		this.expiryDate = expiryDate;
		this.price = price;
		this.discount = discount;
		this.condition = condition;
		this.categories = categories;
		this.shoppingLists = shoppingLists;
		this.recipes = recipes;
		this.inventories = inventories;
	}

	public Item(String name, Date expiryDate, double price, double discount, String condition,
			Set<ItemCategory> categories, Set<ShoppingListItem> shoppingLists, Set<ItemRecipe> recipes,
			Set<ItemInventory> inventories) {
		super();
		this.name = name;
		this.expiryDate = expiryDate;
		this.price = price;
		this.discount = discount;
		this.condition = condition;
		this.categories = categories;
		this.shoppingLists = shoppingLists;
		this.recipes = recipes;
		this.inventories = inventories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Set<ItemCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<ItemCategory> categories) {
		this.categories = categories;
	}

	public Set<ShoppingListItem> getShoppingLists() {
		return shoppingLists;
	}

	public void setShoppingLists(Set<ShoppingListItem> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}

	public Set<ItemRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<ItemRecipe> recipes) {
		this.recipes = recipes;
	}

	public Set<ItemInventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<ItemInventory> inventories) {
		this.inventories = inventories;
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", expiryDate=" + expiryDate + ", price=" + price + ", discount="
				+ discount + ", condition=" + condition + ", categories=" + categories + ", shoppingLists="
				+ shoppingLists + ", recipes=" + recipes + ", inventories=" + inventories + "]";
	}
}
