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



    public FoodPlan(Long id, String name, @Size(min = 1, max = 7) Set<DailyMealsRecipe> recipes, String description, User user) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodPlan)) return false;
        FoodPlan foodPlan = (FoodPlan) o;
        return Objects.equals(id, foodPlan.id) && Objects.equals(name, foodPlan.name) && Objects.equals(recipes, foodPlan.recipes) && Objects.equals(description, foodPlan.description) && Objects.equals(user, foodPlan.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipes, description, user);
    }

    @Override
    public String toString() {
        return "FoodPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipes=" + recipes +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
