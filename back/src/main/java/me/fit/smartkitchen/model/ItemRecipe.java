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
	@NamedQuery(name = ItemRecipe.GET_ALL_ITEM_RECIPES, query = "Select i from ItemRecipe i")
})
public class ItemRecipe {
	
	public static final String GET_ALL_ITEM_RECIPES = "ItemRecipe.getAllItemRecipes";

	
	@Id
	@SequenceGenerator(name = "itemRecipeSequence", sequenceName = "item_recipe_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemRecipeSequence")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	@JsonBackReference(value = "item_recipe")
	private Recipe recipe;
	
	public ItemRecipe() {
		super();
	}

	public ItemRecipe(Long id, Item item, Recipe recipe) {
		super();
		this.id = id;
		this.item = item;
		this.recipe = recipe;
	}

	public ItemRecipe(Item item, Recipe recipe) {
		super();
		this.item = item;
		this.recipe = recipe;
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
		ItemRecipe other = (ItemRecipe) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemRecipe [id=" + id + ", item=" + item + ", recipe=" + recipe + "]";
	}

}
