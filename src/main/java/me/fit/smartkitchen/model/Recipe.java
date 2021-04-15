package me.fit.smartkitchen.model;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {
	@Id
	@SequenceGenerator(name = "recipeSequence", sequenceName = "recipe_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "recipeSequence")
	private Long id;
	private String name;
	private String description;
	private Time duration;
	@OneToMany
	private Set<ItemRecipe> ingredients;
	@OneToMany
	private Set<DailyMealsRecipe> dailyMeals;
	
	public Recipe() {
		super();
	}

	public Recipe(Long id, String name, String description, Time duration, Set<ItemRecipe> ingredients,
			Set<DailyMealsRecipe> dailyMeals) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.ingredients = ingredients;
		this.dailyMeals = dailyMeals;
	}

	public Recipe(String name, String description, Time duration, Set<ItemRecipe> ingredients,
			Set<DailyMealsRecipe> dailyMeals) {
		super();
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.ingredients = ingredients;
		this.dailyMeals = dailyMeals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Set<ItemRecipe> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<ItemRecipe> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<DailyMealsRecipe> getDailyMeals() {
		return dailyMeals;
	}

	public void setDailyMeals(Set<DailyMealsRecipe> dailyMeals) {
		this.dailyMeals = dailyMeals;
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
		Recipe other = (Recipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration
				+ ", ingredients=" + ingredients + ", dailyMeals=" + dailyMeals + "]";
	}

}
