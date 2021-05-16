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


import me.fit.smartkitchen.model.Inventory;
import me.fit.smartkitchen.service.api.InventoryService;

@Path("/rest")
public class InventoryRest {

	@Inject
	private InventoryService inventoryService;
	
	@GET
	@Path("showInventory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inventory() {
		List<Inventory> inventory = inventoryService.getAllInventory();
		return Response.ok(inventory).build();
	}
	
	@PUT
	@Path("updateInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateList(Inventory inventory) {
		inventoryService.updateInventory(inventory);
		return Response.ok().build();
	}

	
	@POST
	@Path("addInventory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addInventory(Inventory inventory) {
		inventoryService.createInventory(inventory);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("deleteInventory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteInventory(Inventory inventory) {
		inventoryService.deleteInventory(inventory);
		return Response.ok().build();
	}
}

