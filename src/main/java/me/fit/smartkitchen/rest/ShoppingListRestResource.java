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

import me.fit.smartkitchen.model.ShoppingList;
import me.fit.smartkitchen.service.api.ShoppingListService;

@Path("/rest")
public class ShoppingListRestResource {

	@Inject
	ShoppingListService shoppingListService;
	
	@POST
	@Path("createShoppingList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createList(ShoppingList shoppingList) {
		shoppingListService.createShoppingList(shoppingList);
		return Response.ok().build();
	}

	@PUT
	@Path("updateShoppingList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateList(ShoppingList shoppingList) {
		shoppingListService.updateShoppingList(shoppingList);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("deleteShoppingList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteShoppingList(ShoppingList shoppingList) {
		shoppingListService.deleteShoppingList(shoppingList);
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
	@Path("getListsByUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListsByUser(@QueryParam("username") String username) {
		List<ShoppingList> lists = shoppingListService.getListsByUser(username);
		return Response.ok(lists).build();
	}
}
