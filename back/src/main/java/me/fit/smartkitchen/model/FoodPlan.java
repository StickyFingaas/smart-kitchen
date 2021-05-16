package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@NamedQueries({
	@NamedQuery(name = FoodPlan.GET_ALL_FOOD_PLANS, query = "Select fp from FoodPlan fp")
})
public class FoodPlan {

	public static final String GET_ALL_FOOD_PLANS = "getAllFoodPlans";

	@Id
	@SequenceGenerator(name = "foodPlanSequence", sequenceName = "food_plan_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "foodPlanSequence")
	private Long id;
	private String name;
	@OneToMany(mappedBy = "foodPlan")
	@Size(min = 1, max = 7)
	private Set<DailyMealsFoodPlan> recipes;
	private String description;
	@ManyToOne
	@JoinColumn(name = "kitchenuser_id", nullable = true)
	private KitchenUser kitchenUser;

	public FoodPlan() {
		super();
	}

	public FoodPlan(Long id, String name, @Size(min = 1, max = 7) Set<DailyMealsFoodPlan> recipes, String description,
			KitchenUser kitchenUser) {
		this.id = id;
		this.name = name;
		this.recipes = recipes;
		this.description = description;
		this.kitchenUser = kitchenUser;
	}

	public FoodPlan(String name, String description, KitchenUser kitchenUser) {
		super();
		this.name = name;
		this.description = description;
		this.kitchenUser = kitchenUser;
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
	
	public KitchenUser getKitchenUser() {
		return kitchenUser;
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
	
	public void setKitchenUser(KitchenUser kitchenUser) {
		this.kitchenUser = kitchenUser;
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
				+ ", kitchenUser=" + kitchenUser + "]";
	}

}
