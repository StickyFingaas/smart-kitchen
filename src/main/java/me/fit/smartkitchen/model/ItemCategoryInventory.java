
package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemCategoryInventory {

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private long id;
	@ManyToOne
	private Item ItemCategory;
	@ManyToOne
	private Inventory inventory;

	public ItemCategoryInventory(long id, Item itemCategory, Inventory inventory) {
		super();
		this.id = id;
		ItemCategory = itemCategory;
		this.inventory = inventory;
	}

	public ItemCategoryInventory() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Item getItemCategory() {
		return ItemCategory;
	}

	public void setItemCategory(Item itemCategory) {
		ItemCategory = itemCategory;
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
		ItemCategoryInventory other = (ItemCategoryInventory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCategoryInventory [id=" + id + ", ItemCategory=" + ItemCategory + ", inventory=" + inventory + "]";
	}

}