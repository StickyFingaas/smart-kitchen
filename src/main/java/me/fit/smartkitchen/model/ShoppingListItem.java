package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ShoppingListItem {

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private long id;
	@ManyToOne
	private ItemCategory item;
	private int amount;
	@OneToMany
	private Set<ShoppingList> shoppingList;

	public ShoppingListItem(ItemCategory item, int amount, Set<ShoppingList> shoppingList) {
		super();
		this.item = item;
		this.amount = amount;
		this.shoppingList = shoppingList;
	}

	public ShoppingListItem() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemCategory getItem() {
		return item;
	}

	public void setItem(ItemCategory item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Set<ShoppingList> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(Set<ShoppingList> shoppingList) {
		this.shoppingList = shoppingList;
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
		ShoppingListItem other = (ShoppingListItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingListItem [id=" + id + ", item=" + item + ", " + "shoppingList=" + shoppingList + "]";
	}

}
