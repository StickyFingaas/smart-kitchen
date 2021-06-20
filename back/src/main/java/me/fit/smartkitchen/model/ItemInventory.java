
package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@NamedQueries({
	@NamedQuery(name = ItemInventory.GET_ALL_ITEM_INVENTORIES, query = "Select i from ItemInventory i")
})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
//				  property  = "id", 
//				  scope     = Long.class)
public class ItemInventory {
	
	public static final String GET_ALL_ITEM_INVENTORIES = "ItemInventory.getAllItemInventories";

	@Id
	@SequenceGenerator(name = "itemInventorySequence", sequenceName = "item_inventory_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemInventorySequence")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;
	@ManyToOne
	@JoinColumn(name = "inventory_id", nullable = false)
	@JsonBackReference(value = "item_inv")
	private Inventory inventory;
	
	public ItemInventory() {
		super();
	}

	public ItemInventory(Long id, Item item, Inventory inventory) {
		super();
		this.id = id;
		this.item = item;
		this.inventory = inventory;
	}

	public ItemInventory(Item item, Inventory inventory) {
		super();
		this.item = item;
		this.inventory = inventory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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
		ItemInventory other = (ItemInventory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemInventory [id=" + id + ", item=" + item + ", inventory=" + inventory + "]";
	}

}