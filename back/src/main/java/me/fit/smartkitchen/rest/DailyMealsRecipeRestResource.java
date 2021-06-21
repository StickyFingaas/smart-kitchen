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

import me.fit.smartkitchen.model.DailyMealsRecipe;
import me.fit.smartkitchen.service.api.DailyMealsRecipeService;

@Path("/rest")
public class DailyMealsRecipeRestResource {

	@Inject
	private DailyMealsRecipeService dailyMealsRecipeService;

	@POST
	@Path("createDailyMealsRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMealRecipe(DailyMealsRecipe dailyMealsRecipe) {
		dailyMealsRecipeService.createDailyMealsRecipe(dailyMealsRecipe);
		return Response.ok().build();
	}

	@PUT
	@Path("updateDailyMealsRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMealRecipe(DailyMealsRecipe dailyMealsRecipe) {
		dailyMealsRecipeService.updateDailyMealsRecipe(dailyMealsRecipe);
		return Response.ok().build();
	}

	@DELETE
	@Path("deleteDailyMealsRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMealRecipe(DailyMealsRecipe dailyMealsRecipe) {
		dailyMealsRecipeService.deleteDailyMealsRecipe(dailyMealsRecipe);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllDailyMealsRecipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDailyMealsRecipes() {
		List<DailyMealsRecipe> dailyMealsRecipes = dailyMealsRecipeService.getDailyMealsRecipes();
		return Response.ok(dailyMealsRecipes).build();
	}
}
