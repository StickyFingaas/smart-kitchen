package me.fit.smartkitchen.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DailyMeals {
	
	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private Long id;
	
	@ManyToOne
	private DailyMealsRecipe breakfast;
	
	@ManyToOne
	private DailyMealsRecipe lunch;
	
	@ManyToOne
	private DailyMealsRecipe dinner;
	
	private Time reminderB;
	private Time reminderL;
	private Time reminderD;
	
	public DailyMeals(Long id, DailyMealsRecipe breakfast, DailyMealsRecipe lunch, DailyMealsRecipe dinner,
			Time reminderB, Time reminderL, Time reminderD) {
		super();
		this.id = id;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.reminderB = reminderB;
		this.reminderL = reminderL;
		this.reminderD = reminderD;
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
		DailyMeals other = (DailyMeals) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DailyMeals [id=" + id + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner
				+ ", reminderB=" + reminderB + ", reminderL=" + reminderL + ", reminderD=" + reminderD + "]";
	}

}
