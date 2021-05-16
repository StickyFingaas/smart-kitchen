package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DailyMealsRecipe {

	@Id
	@SequenceGenerator(name = "dailyMealsRecipeSequence", sequenceName = "daily_meals_recipe_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "dailyMealsRecipeSequence")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;
	@ManyToOne
	@JoinColumn(name = "dailymeals_id", nullable = false)
	private DailyMeals dailyMeals;
	
	public DailyMealsRecipe() {
		super();
	}

	public DailyMealsRecipe(Long id, Recipe recipe, DailyMeals dailyMeals) {
		super();
		this.id = id;
		this.recipe = recipe;
		this.dailyMeals = dailyMeals;
	}

	public DailyMealsRecipe(Recipe recipe, DailyMeals dailyMeals) {
		super();
		this.recipe = recipe;
		this.dailyMeals = dailyMeals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public DailyMeals getDailyMeals() {
		return dailyMeals;
	}

	public void setDailyMeals(DailyMeals dailyMeals) {
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