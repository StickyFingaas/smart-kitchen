package me.fit.smartkitchen.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import me.fit.smartkitchen.model.Recipe;
import me.fit.smartkitchen.service.api.RecipeService;

@Path("/rest")
public class RecipeRestResource {

	@Inject
	private RecipeService recipeService;
	
	@GET
	@Path("recipe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recipe() {
		List<Recipe> recipe = recipeService.getAllRecipe();
		return Response.ok(recipe).build();
	}
	
	@PUT
	@Path("edit-recipe")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateList(Recipe recipe) {
		recipeService.updateRecipe(recipe);
		return Response.ok().build();
	}

	
	@POST
	@Path("add-recipe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRecipe(Recipe recipe) {
		recipeService.createRecipe(recipe);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("delete-recipe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRecipe(Recipe recipe) {
		recipeService.deleteRecipe(recipe);
		return Response.ok().build();
	}
}
