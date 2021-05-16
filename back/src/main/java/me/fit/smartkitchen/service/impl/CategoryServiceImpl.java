package me.fit.smartkitchen.service.impl;

import me.fit.smartkitchen.model.Category;
import me.fit.smartkitchen.service.api.CategoryService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService{

    @Inject
    EntityManager em;

    @Transactional
    public void createCategory(Category category) {
        em.persist(category);
    }

    @Transactional
    public void updateCategory(Category category) {
        em.merge(category);
    }

    @Transactional
    public List<Category> getAllCategories() {
        List<Category> categories = em.createNamedQuery(Category.GET_ALL_CATEGORIES, Category.class).getResultList();
        return categories;
    }


    @Transactional
    public void deleteCategory(Category category) {
        em.remove(em.contains(category) ? category : em.merge(category));

    }

}
