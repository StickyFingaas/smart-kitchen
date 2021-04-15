package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class ItemCategoryRecipe {
	@Id
	@SequenceGenerator(name = "itemCategoryRecipeSequence", sequenceName = "itemCategoryRecipe_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemCategoryRecipeSequence")
	private long id;
	@OneToMany
	private Set<Item> itemCategory;
	@OneToOne
	private Recipe recipe;

	public ItemCategoryRecipe(Set<Item> itemCategory, Recipe recipe) {
		super();
		this.itemCategory = itemCategory;
		this.recipe = recipe;
	}

	public ItemCategoryRecipe() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Item> getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Set<Item> itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
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
		ItemCategoryRecipe other = (ItemCategoryRecipe) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCategoryRecipe [id=" + id + ", itemCategory=" + itemCategory + ", recipe=" + recipe + "]";
	}

}
