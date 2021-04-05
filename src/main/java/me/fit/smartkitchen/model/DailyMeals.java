package me.fit.smartkitchen.model;

import java.sql.Time;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;

@Entity
public class DailyMeals {
	
//	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
//	@GeneratedValue(generator = "itemSequence")
	
	@ManyToOne
	private DailyMealsRecipe breakfast;
	
	@ManyToOne
	private DailyMealsRecipe lunch;
	
	@ManyToOne
	private DailyMealsRecipe dinner;
	
	private Time reminderB;
	private Time reminderL;
	private Time reminderD;
	
	public DailyMeals(DailyMealsRecipe breakfast, DailyMealsRecipe lunch, DailyMealsRecipe dinner, Time reminderB,
			Time reminderL, Time reminderD) {
		super();
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.reminderB = reminderB;
		this.reminderL = reminderL;
		this.reminderD = reminderD;
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
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((breakfast == null) ? 0 : breakfast.hashCode());
//		result = prime * result + ((dinner == null) ? 0 : dinner.hashCode());
//		result = prime * result + ((lunch == null) ? 0 : lunch.hashCode());
//		result = prime * result + ((reminderB == null) ? 0 : reminderB.hashCode());
//		result = prime * result + ((reminderD == null) ? 0 : reminderD.hashCode());
//		result = prime * result + ((reminderL == null) ? 0 : reminderL.hashCode());
//		return result;
//	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DailyMeals other = (DailyMeals) obj;
//		if (breakfast == null) {
//			if (other.breakfast != null)
//				return false;
//		} else if (!breakfast.equals(other.breakfast))
//			return false;
//		if (dinner == null) {
//			if (other.dinner != null)
//				return false;
//		} else if (!dinner.equals(other.dinner))
//			return false;
//		if (lunch == null) {
//			if (other.lunch != null)
//				return false;
//		} else if (!lunch.equals(other.lunch))
//			return false;
//		if (reminderB == null) {
//			if (other.reminderB != null)
//				return false;
//		} else if (!reminderB.equals(other.reminderB))
//			return false;
//		if (reminderD == null) {
//			if (other.reminderD != null)
//				return false;
//		} else if (!reminderD.equals(other.reminderD))
//			return false;
//		if (reminderL == null) {
//			if (other.reminderL != null)
//				return false;
//		} else if (!reminderL.equals(other.reminderL))
//			return false;
//		return true;
//	}
	
	@Override
	public String toString() {
		return "DailyMeals [breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + ", reminderB="
				+ reminderB + ", reminderL=" + reminderL + ", reminderD=" + reminderD + "]";
	}
	
	

}
