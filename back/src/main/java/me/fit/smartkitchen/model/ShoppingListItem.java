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
	@NamedQuery(name = ShoppingListItem.GET_ALL_SHOPPING_LIST_ITEMS, query = "Select s from ShoppingListItem s")
})
public class ShoppingListItem {
	
	public static final String GET_ALL_SHOPPING_LIST_ITEMS = "ShoppingListItem.getAllItemInventories";

	@Id
	@SequenceGenerator(name = "shoppingListItemSequence", sequenceName = "shopping_list_item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "shoppingListItemSequence")
	private Long id;
	private int amount;
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;
	@ManyToOne
	@JoinColumn(name = "shoppinglist_id", nullable = false)
	@JsonBackReference(value = "shop_item")
	private ShoppingList shoppingList;

	public ShoppingListItem() {
		super();
	}

	public ShoppingListItem(Long id, int amount, Item item, ShoppingList shoppingList) {
		super();
		this.id = id;
		this.amount = amount;
		this.item = item;
		this.shoppingList = shoppingList;
	}

	public ShoppingListItem(int amount, Item item, ShoppingList shoppingList) {
		super();
		this.amount = amount;
		this.item = item;
		this.shoppingList = shoppingList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
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
		return "ShoppingListItem [id=" + id + ", amount=" + amount + ", item=" + item + ", shoppingList=" + shoppingList
				+ "]";
	}

}
