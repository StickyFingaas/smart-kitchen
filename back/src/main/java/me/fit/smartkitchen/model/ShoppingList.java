package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQueries({ @NamedQuery(name = ShoppingList.GET_ALL_LISTS, query = "Select sl from ShoppingList sl"),
		@NamedQuery(name = ShoppingList.GET_LISTS_BY_USER, query = "Select sl from ShoppingList sl where sl.kitchenUser.username = :kitchenUser") })
public class ShoppingList {

	public static final String GET_ALL_LISTS = "ShoppingList.getAllLists";
	public static final String GET_LISTS_BY_USER = "ShoppingList.getListsByUser";

	@Id
	@SequenceGenerator(name = "shoppingListSequence", sequenceName = "shopping_list_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "shoppingListSequence")
	private Long id;
	private String name;
	@OneToMany(mappedBy = "shoppingList", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "shop_item")
	private Set<ShoppingListItem> items;
	@ManyToOne
	@JoinColumn(name = "kitchenuser_id", nullable = false)
	@JsonBackReference(value = "user_shop")
	private KitchenUser kitchenUser;
	
	public ShoppingList() {
		super();
	}

	public ShoppingList(String name, Set<ShoppingListItem> items, KitchenUser kitchenUser) {
		super();
		this.name = name;
		this.items = items;
		this.kitchenUser = kitchenUser;
	}

	public ShoppingList(Long id, String name, Set<ShoppingListItem> items, KitchenUser kitchenUser) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
		this.kitchenUser = kitchenUser;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
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

	public Set<ShoppingListItem> getItems() {
		return items;
	}

	public void setItems(Set<ShoppingListItem> items) {
		this.items = items;
	}

	public KitchenUser getKitchenUser() {
		return kitchenUser;
	}

	public void setKitchenUser(KitchenUser kitchenUser) {
		this.kitchenUser = kitchenUser;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingList other = (ShoppingList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingList [id=" + id + ", name=" + name + ", items=" + items + ", kitchenUser=" + kitchenUser.getUsername() + "]";
	}

}
