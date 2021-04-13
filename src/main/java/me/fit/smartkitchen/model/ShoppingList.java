package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class ShoppingList {

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private long id;
	private String name;
	@OneToMany
	private Set<ShoppingListItem> items;
	@OneToOne
	private User user;

	public ShoppingList(String name, Set<ShoppingListItem> items) {
		super();
		this.name = name;
		this.items = items;
	}

	public ShoppingList() {
		super();
	}

	public long getId() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		ShoppingList other = (ShoppingList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingList [id=" + id + ", name=" + name + ", items=" + items + ", user=" + user + "]";
	}

}
