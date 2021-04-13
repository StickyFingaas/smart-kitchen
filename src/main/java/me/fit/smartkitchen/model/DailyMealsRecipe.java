package me.fit.smartkitchen.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class DailyMealsRecipe {

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private long id;

	@OneToMany
	private Set<Recipe> recipe;

	@OneToMany
	private Set<DailyMeals> dailyMeals;

	public DailyMealsRecipe(Set<Recipe> recipe, Set<DailyMeals> dailyMeals) {
		super();
		this.recipe = recipe;
		this.dailyMeals = dailyMeals;
	}

	public DailyMealsRecipe() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Recipe> getRecipe() {
		return recipe;
	}

	public void setRecipe(Set<Recipe> recipe) {
		this.recipe = recipe;
	}

	public Set<DailyMeals> getDailyMeals() {
		return dailyMeals;
	}

	public void setDailyMeals(Set<DailyMeals> dailyMeals) {
		this.dailyMeals = dailyMeals;
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
		DailyMealsRecipe other = (DailyMealsRecipe) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DailyMealsRecipe [id=" + id + ", recipe=" + recipe + ", dailyMeals=" + dailyMeals + "]";
	}

}