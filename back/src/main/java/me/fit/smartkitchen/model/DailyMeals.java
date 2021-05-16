package me.fit.smartkitchen.model;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({ @NamedQuery(name = DailyMeals.GET_ALL_MEALS, query = "Select dm from DailyMeals dm"),
//		@NamedQuery(name = DailyMeals.GET_MEALS_BY_USER, query = "Select dm from DailyMeals dm where dm.kitchenUser.username = :kitchenUser")
})

public class DailyMeals {
	
	public static final String GET_ALL_MEALS = "DailyMeals.getAllDailyMeals";
	public static final String GET_MEALS_BY_USER = "DailyMeals.getMealsByUser";


	@Id
	@SequenceGenerator(name = "dailyMealsSequence", sequenceName = "daily_meals_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "dailyMealsSequence")
	private Long id;
	@OneToOne
	private DailyMealsRecipe breakfast;
	@OneToOne
	private DailyMealsRecipe lunch;
	@OneToOne
	private DailyMealsRecipe dinner;
	private Time reminderB;
	private Time reminderL;
	private Time reminderD;
	@OneToMany(mappedBy = "dailyMeals")
	private Set<DailyMealsFoodPlan> foodPlans;
	
	public DailyMeals() {
		super();
	}

	public DailyMeals(Long id, DailyMealsRecipe breakfast, DailyMealsRecipe lunch, DailyMealsRecipe dinner,
			Time reminderB, Time reminderL, Time reminderD, Set<DailyMealsFoodPlan> foodPlans) {
		super();
		this.id = id;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.reminderB = reminderB;
		this.reminderL = reminderL;
		this.reminderD = reminderD;
		this.foodPlans = foodPlans;
	}

	public DailyMeals(DailyMealsRecipe breakfast, DailyMealsRecipe lunch, DailyMealsRecipe dinner, Time reminderB,
			Time reminderL, Time reminderD, Set<DailyMealsFoodPlan> foodPlans) {
		super();
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.reminderB = reminderB;
		this.reminderL = reminderL;
		this.reminderD = reminderD;
		this.foodPlans = foodPlans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DailyMealsRecipe getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(DailyMealsRecipe breakfast) {
		this.breakfast = breakfast;
	}

	public DailyMealsRecipe getLunch() {
		return lunch;
	}

	public void setLunch(DailyMealsRecipe lunch) {
		this.lunch = lunch;
	}

	public DailyMealsRecipe getDinner() {
		return dinner;
	}

	public void setDinner(DailyMealsRecipe dinner) {
		this.dinner = dinner;
	}

	public Time getReminderB() {
		return reminderB;
	}

	public void setReminderB(Time reminderB) {
		this.reminderB = reminderB;
	}

	public Time getReminderL() {
		return reminderL;
	}

	public void setReminderL(Time reminderL) {
		this.reminderL = reminderL;
	}

	public Time getReminderD() {
		return reminderD;
	}

	public void setReminderD(Time reminderD) {
		this.reminderD = reminderD;
	}

	public Set<DailyMealsFoodPlan> getFoodPlans() {
		return foodPlans;
	}

	public void setFoodPlans(Set<DailyMealsFoodPlan> foodPlans) {
		this.foodPlans = foodPlans;
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
		DailyMeals other = (DailyMeals) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DailyMeals [id=" + id + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner
				+ ", reminderB=" + reminderB + ", reminderL=" + reminderL + ", reminderD=" + reminderD + ", foodPlans="
				+ foodPlans + "]";
	}

}
