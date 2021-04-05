package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity

public class ItemCategoryRecipe {
	@Id
	@SequenceGenerator(name = "itemCategoryRecipeSequence", sequenceName = "itemCategoryRecipe_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemCategoryRecipeSequence")
 private Integer id;
 private Item itemCategory;
 @OneToOne
 private Recipe recipe;
public ItemCategoryRecipe(Integer id, Item itemCategory, Recipe recipe) {
	super();
	this.id = id;
	this.itemCategory = itemCategory;
	this.recipe = recipe;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Item getItemCategory() {
	return itemCategory;
}
public void setItemCategory(Item itemCategory) {
	this.itemCategory = itemCategory;
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
	ItemCategoryRecipe other = (ItemCategoryRecipe) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
@Override
public String toString() {
	return "ItemCategoryRecipe [id=" + id + ", itemCategory=" + itemCategory + ", recipe=" + recipe + "]";
}
 
 
}
