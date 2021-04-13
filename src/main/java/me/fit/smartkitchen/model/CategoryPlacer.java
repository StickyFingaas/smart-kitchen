package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class CategoryPlacer {

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private long id;
	@OneToMany
	private Set<Category> category;
	@OneToMany
	private Set<ItemCategory> itemCategory;

	public CategoryPlacer(Set<Category> category, Set<ItemCategory> itemCategory) {
		super();
		this.category = category;
		this.itemCategory = itemCategory;
	}

	public CategoryPlacer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<ItemCategory> getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Set<ItemCategory> itemCategory) {
		this.itemCategory = itemCategory;
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
		CategoryPlacer other = (CategoryPlacer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryPlacer [id=" + id + ", category=" + category + ", itemCategory=" + itemCategory + "]";
	}

}
