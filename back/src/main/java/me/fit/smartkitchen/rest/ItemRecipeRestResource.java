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

import me.fit.smartkitchen.model.ItemRecipe;
import me.fit.smartkitchen.service.api.ItemRecipeService;

@Path("/rest")
public class ItemRecipeRestResource {

	@Inject
	private ItemRecipeService itemRecipeService;
	@POST
	@Path("createItemRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addItemRecipe(ItemRecipe itemRecipe) {
		itemRecipeService.createItemRecipe(itemRecipe);
		return Response.ok().build();
	}
	
	@PUT
	@Path("updateItemRecipe")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateItemRecipe(ItemRecipe itemRecipe) {
		itemRecipeService.updateItemRecipe(itemRecipe);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("deleteItemRecipe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteItemRecipe(ItemRecipe itemRecipe) {
		itemRecipeService.deleteItemRecipe(itemRecipe);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllItemRecipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItemRecipes() {
		List<ItemRecipe> itemRecipe = itemRecipeService.getAllItemRecipes();
		return Response.ok(itemRecipe).build();
	}
}
