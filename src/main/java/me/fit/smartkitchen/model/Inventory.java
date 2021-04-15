package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Inventory {

	@Id
	@SequenceGenerator(name = "inventorySequence", sequenceName = "inventory_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "inventorySequence")
	private Long id;
	@OneToMany
	private Set<ItemInventory> items;
	@OneToOne
	private User user;
	
	public Inventory() {
		super();
	}

	public Inventory(Long id, Set<ItemInventory> items, User user) {
		super();
		this.id = id;
		this.items = items;
		this.user = user;
	}

	public Inventory(Set<ItemInventory> items, User user) {
		super();
		this.items = items;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<ItemInventory> getItems() {
		return items;
	}

	public void setItems(Set<ItemInventory> items) {
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
		Inventory other = (Inventory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", items=" + items + ", user=" + user + "]";
	}

}