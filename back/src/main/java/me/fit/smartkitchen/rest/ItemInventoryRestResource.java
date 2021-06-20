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


import me.fit.smartkitchen.model.ItemInventory;
import me.fit.smartkitchen.service.api.ItemInventoryService;

@Path("/rest")
public class ItemInventoryRestResource {

	@Inject
	private ItemInventoryService itemInventoryService;
	
	@GET
	@Path("showItemInventories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItemInventories() {
		List<ItemInventory> itemInventory = itemInventoryService.getAllItemInventories();
		return Response.ok(itemInventory).build();
	}
	
	@PUT
	@Path("updateItemInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateItemInventory(ItemInventory itemInventory) {
		itemInventoryService.updateItemInventory(itemInventory);
		return Response.ok().build();
	}

	
	@POST
	@Path("addItemInventory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addItemInventory(ItemInventory itemInventory) {
		itemInventoryService.createItemInventory(itemInventory);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("deleteItemInventory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteItemInventory(ItemInventory itemInventory) {
		itemInventoryService.deleteItemInventory(itemInventory);
		return Response.ok().build();
	}
}

