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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.fit.smartkitchen.model.DailyMeals;
import me.fit.smartkitchen.service.api.DailyMealsService;

@Path("/rest")

public class DailyMealsRestResource {

	@Inject
	DailyMealsService dailyMealsService;
	
	@POST
	@Path("createDailyMeals")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMeal(DailyMeals dailyMeals) {
		dailyMealsService.createDailyMeal(dailyMeals);
		return Response.ok().build();
	}

	@PUT
	@Path("updateDailyMeals")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMeal(DailyMeals dailyMeals) {
		dailyMealsService.updateDailyMeal(dailyMeals);
		return Response.ok().build();
	}

	@DELETE
	@Path("deleteDailyMeals")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMeal(DailyMeals dailyMeals) {
		dailyMealsService.deleteDailyMeal(dailyMeals);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllDailyMeals")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDailyMeals() {
		List<DailyMeals> meals = dailyMealsService.getAllDailyMeals();
		return Response.ok(meals).build();
	}
	
	@GET
	@Path("getMealsByUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMealsByUser(@QueryParam("username") String username) {
		List<DailyMeals> meals = dailyMealsService.getMealsByUser(username);
		return Response.ok(meals).build();
	}
	
}
