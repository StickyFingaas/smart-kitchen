package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ShoppingList {

	@Id
	@SequenceGenerator(name = "shoppingListSequence", sequenceName = "shopping_list_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "shoppingListSequence")
	private Long id;
	private String name;
	@OneToMany(mappedBy = "shoppingList")
	private Set<ShoppingListItem> items;
	@ManyToOne
	@JoinColumn(name = "kitchenuser_id", nullable = false)
	private KitchenUser kitchenUser;

	public ShoppingList() {
		super();
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

	public ShoppingList(String name, Set<ShoppingListItem> items, KitchenUser kitchenUser) {
		super();
		this.name = name;
		this.items = items;
		this.kitchenUser = kitchenUser;
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
		return "ShoppingList [id=" + id + ", name=" + name + ", items=" + items + ", kitchenUser=" + kitchenUser + "]";
	}

}
