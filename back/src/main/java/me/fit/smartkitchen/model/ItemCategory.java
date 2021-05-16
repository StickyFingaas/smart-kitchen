package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemCategory {

	@Id
	@SequenceGenerator(name = "itemCategorySequence", sequenceName = "item_category_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemCategorySequence")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	public ItemCategory() {
		super();
	}

	public ItemCategory(Long id, Category category, Item item) {
		super();
		this.id = id;
		this.category = category;
		this.item = item;
	}

	public ItemCategory(Category category, Item item) {
		super();
		this.category = category;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
		ItemCategory other = (ItemCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCategory [id=" + id + ", category=" + category + ", item=" + item + "]";
	}

}
