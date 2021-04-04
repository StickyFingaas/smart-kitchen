package me.fit.smartkitchen.model;

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
	private Long id;
	@OneToMany
	private Category category;
	@OneToMany
	private ItemCategory itemCategory;
	
	
	public CategoryPlacer(Category category, ItemCategory itemCategory) {
		super();
		this.category = category;
		this.itemCategory = itemCategory;
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
	public ItemCategory getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryPlacer [id=" + id + ", category=" + category + ", itemCategory=" + itemCategory + "]";
	}

}	
