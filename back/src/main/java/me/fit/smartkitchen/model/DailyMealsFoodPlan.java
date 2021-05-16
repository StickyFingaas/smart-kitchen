package me.fit.smartkitchen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DailyMealsFoodPlan {
	
	@Id
	@SequenceGenerator(name = "dailyMealsFoodPlanSequence", sequenceName = "daily_meals_food_plan_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "dailyMealsFoodPlanSequence")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "dailymeals_id", nullable = false)
	private DailyMeals dailyMeals;
	@ManyToOne
	@JoinColumn(name = "foodplan_id", nullable = false)
	private FoodPlan foodPlan;
	
	public DailyMealsFoodPlan() {
		super();
	}

	public DailyMealsFoodPlan(Long id, DailyMeals dailyMeals, FoodPlan foodPlan) {
		super();
		this.id = id;
		this.dailyMeals = dailyMeals;
		this.foodPlan = foodPlan;
	}

	public DailyMealsFoodPlan(DailyMeals dailyMeals, FoodPlan foodPlan) {
		super();
		this.dailyMeals = dailyMeals;
		this.foodPlan = foodPlan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DailyMeals getDailyMeals() {
		return dailyMeals;
	}

	public void setDailyMeals(DailyMeals dailyMeals) {
		this.dailyMeals = dailyMeals;
	}

	public FoodPlan getFoodPlan() {
		return foodPlan;
	}

	public void setFoodPlan(FoodPlan foodPlan) {
		this.foodPlan = foodPlan;
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
		DailyMealsFoodPlan other = (DailyMealsFoodPlan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DailyMealsFoodPlan [id=" + id + ", dailyMeals=" + dailyMeals + ", foodPlan=" + foodPlan + "]";
	}

}
