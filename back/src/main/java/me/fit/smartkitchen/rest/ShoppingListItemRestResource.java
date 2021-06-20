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

import me.fit.smartkitchen.model.ShoppingListItem;
import me.fit.smartkitchen.service.api.ShoppingListItemService;

@Path("/rest")
public class ShoppingListItemRestResource {
	
	@Inject
	private ShoppingListItemService shoppingListItemService;
	
	@GET
	@Path("showShoppingListItems")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllShoppingListItems() {
		List<ShoppingListItem> shoppingListItem = shoppingListItemService.getAllShoppingListItems();
		return Response.ok(shoppingListItem).build();
	}
	
	@PUT
	@Path("updateShoppingListItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateItemInventory(ShoppingListItem shoppingListItem) {
		shoppingListItemService.updateShoppingListItem(shoppingListItem);
		return Response.ok().build();
	}

	
	@POST
	@Path("addShoppingListItem")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addItemInventory(ShoppingListItem shoppingListItem) {
		shoppingListItemService.createShoppingListItem(shoppingListItem);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("deleteShoppingListItem")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteItemInventory(ShoppingListItem shoppingListItem) {
		shoppingListItemService.createShoppingListItem(shoppingListItem);
		return Response.ok().build();
	}

}
