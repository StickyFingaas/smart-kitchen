package me.fit.smartkitchen.model;
import java.sql.Time;
import java.util.List;

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
private Integer id;
private String name;
private String description;
private Time duartion;
@OneToMany
private List<ItemCategoryRecipe> ingredients;
}
