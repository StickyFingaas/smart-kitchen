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

import me.fit.smartkitchen.model.ItemCategory;
import me.fit.smartkitchen.service.api.ItemCategoryService;


@Path("/rest")
public class ItemCategoryRestResource {

	@Inject
	private ItemCategoryService itemCategoryService;
	
	@POST
	@Path("createItemCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addItemCategory(ItemCategory itemCategory) {
		itemCategoryService.createItemCategory(itemCategory);
		return Response.ok().build();
	}
	
	@PUT
	@Path("updateItemCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateItemCategory(ItemCategory itemCategory) {
		itemCategoryService.updateItemCategory(itemCategory);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("deleteItemCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteItemCategory(ItemCategory itemCategory) {
		itemCategoryService.deleteItemCategory(itemCategory);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllItemCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItemCateories() {
		List<ItemCategory> itemCategory = itemCategoryService.getAllItemCategories();
		return Response.ok(itemCategory).build();
	}
}
