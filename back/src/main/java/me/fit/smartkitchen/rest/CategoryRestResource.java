package me.fit.smartkitchen.rest;

import me.fit.smartkitchen.model.Category;
import me.fit.smartkitchen.service.api.CategoryService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rest")
public class CategoryRestResource {

    @Inject
    CategoryService categoryService;

    @Inject
    EntityManager em;

    @POST
    @Path("createCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(Category category) {

        try {
            categoryService.createCategory(category);
        }
        catch (Exception e) {
            return Response.ok(e).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("updateCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(Category category) {
        categoryService.updateCategory(category);
        return Response.ok().build();
    }

    @GET
    @Path("getCategories")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllFoodPlans(){
        List<Category> categories = categoryService.getAllCategories();
        return Response.ok(categories).build();
    }

    @DELETE
    @Path("deleteCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(Category category) {
        categoryService.deleteCategory(category);
        return Response.ok().build();
    }


}
