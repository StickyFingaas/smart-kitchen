package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class FoodPlan {

	@Id
	@SequenceGenerator(name = "foodPlanSequence", sequenceName = "food_plan_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "foodPlanSequence")
	private Long id;
	private String name;
	@OneToMany
	@Size(min = 1, max = 7)
	private Set<DailyMealsFoodPlan> recipes;
	private String description;
	@ManyToOne
	private User user;

	public FoodPlan() {
		super();
	}

	public FoodPlan(Long id, String name, @Size(min = 1, max = 7) Set<DailyMealsFoodPlan> recipes, String description,
			User user) {
		this.id = id;
		this.name = name;
		this.recipes = recipes;
		this.description = description;
		this.user = user;
	}

	public FoodPlan(String name, @Size(min = 1, max = 7) Set<DailyMealsFoodPlan> recipes, String description,
			User user) {
		super();
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

	public Set<DailyMealsFoodPlan> getRecipes() {
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

	public void setRecipes(Set<DailyMealsFoodPlan> recipes) {
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
		return "FoodPlan [id=" + id + ", name=" + name + ", recipes=" + recipes + ", description=" + description
				+ ", user=" + user + "]";
	}

}
