package me.fit.smartkitchen.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.fit.smartkitchen.model.ShoppingList;
import me.fit.smartkitchen.service.api.ShoppingListService;

@Path("/rest")
public class ShoppingListRestResource {

	@Inject
	ShoppingListService shoppingListService;
	
	@Inject
	EntityManager em;
	
	@POST
	@Path("createShoppingList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createList(ShoppingList shoppingList) {
		shoppingListService.createShoppingList(shoppingList);
		return Response.ok().build();
	}

	@POST
	@Path("updateShoppingList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateList(ShoppingList shoppingList) {
		shoppingListService.updateShoppingList(shoppingList);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllLists")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLists() {
		List<ShoppingList> lists = shoppingListService.getAllLists();
		return Response.ok(lists).build();
	}
	
	@GET
	@Path("getUserLists")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserLists() {
		List<ShoppingList> lists = shoppingListService.getUserLists();
		return Response.ok(lists).build();
	}
}
