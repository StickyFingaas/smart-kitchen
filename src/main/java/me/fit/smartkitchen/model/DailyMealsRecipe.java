package me.fit.smartkitchen.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class DailyMealsRecipe {


    @Id
    @SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "itemSequence")
    private Long id;

    @OneToMany
    private  Recipe recipe;

    @OneToMany
    private DailyMeals dailyMeals;

    public DailyMealsRecipe(Long id, Recipe recipe, DailyMeals dailyMeals) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyMealsRecipe)) return false;
        DailyMealsRecipe that = (DailyMealsRecipe) o;
        return Objects.equals(id, that.id) && Objects.equals(recipe, that.recipe) && Objects.equals(dailyMeals, that.dailyMeals);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
