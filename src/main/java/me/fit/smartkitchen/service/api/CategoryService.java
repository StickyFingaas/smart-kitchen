package me.fit.smartkitchen.service.api;

import me.fit.smartkitchen.model.Category;

import java.util.List;

public interface CategoryService {

    public void createCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(Category category);

    public List<Category> getAllCategories();


}
