package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@NamedQueries({
	@NamedQuery(name = Inventory.GET_ALL_INVENTORIES, query = "Select i from Inventory i")
})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
//				  property  = "id", 
//				  scope     = Long.class)
public class Inventory {
	
	public static final String GET_ALL_INVENTORIES = "Inventory.getAllInventories";
	@Id
	@SequenceGenerator(name = "inventorySequence", sequenceName = "inventory_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "inventorySequence")
	private Long id;
	@OneToMany(mappedBy = "inventory", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "item_inv")
	private Set<ItemInventory> items;
	@OneToOne(mappedBy = "inventory")
	@JsonBackReference(value = "user_inv")
	private KitchenUser kitchenUser;
	
	public Inventory() {
		super();
	}

	public Inventory(Long id, Set<ItemInventory> items, KitchenUser kitchenUser) {
		super();
		this.id = id;
		this.items = items;
		this.kitchenUser = kitchenUser;
	}

	public Inventory(Set<ItemInventory> items, KitchenUser kitchenUser) {
		super();
		this.items = items;
		this.kitchenUser = kitchenUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ItemInventory> getItems() {
		return items;
	}

	public void setItems(Set<ItemInventory> items) {
		this.items = items;
	}

	public KitchenUser getKitchenUser() {
		return kitchenUser;
	}

	public void setKitchenUser(KitchenUser kitchenUser) {
		this.kitchenUser = kitchenUser;
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
		return "Inventory [id=" + id + ", items=" + items + ", kitchenUser=" + kitchenUser + "]";
	}

}