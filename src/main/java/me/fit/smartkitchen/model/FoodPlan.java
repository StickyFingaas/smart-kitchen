package me.fit.smartkitchen.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity

public class FoodPlan {

	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private Long id;
	private String name;

	@OneToMany
	@Size(min = 1, max = 7)
	private Set<DailyMealsRecipe> recipes;
	private String description;
	@OneToOne
	private User user;

	public FoodPlan() {
		super();
	}

	public FoodPlan(Long id, String name, @Size(min = 1, max = 7) Set<DailyMealsRecipe> recipes, String description,
			User user) {
		this.id = id;
		this.name = name;
		this.recipes = recipes;
		this.description = description;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<DailyMealsRecipe> getRecipes() {
		return recipes;
	}

	public String getDescription() {
		return description;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRecipes(Set<DailyMealsRecipe> recipes) {
		this.recipes = recipes;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(User user) {
		this.user = user;
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
		FoodPlan other = (FoodPlan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodPlan{" + "id=" + id + ", name='" + name + '\'' + ", recipes=" + recipes + ", description='"
				+ description + '\'' + ", user=" + user + '}';
	}
}
