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

import me.fit.smartkitchen.model.Item;
import me.fit.smartkitchen.service.api.ItemService;

@Path("/rest")
public class ItemRestResource {
	
	@Inject
	ItemService itemService;
	
    @POST
    @Path("createItem")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(Item item) {
        itemService.createItem(item);
        return Response.ok().build();
    }
    
    @PUT
    @Path("updateItem")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateItem(Item item) {
    	itemService.updateItem(item);
    	return Response.ok().build();
    }
    
    @DELETE
    @Path("deleteItemById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteItem(@QueryParam("id") Long id) {
    	itemService.deleteItem(id);
    	return Response.ok().build();
    }
    
    @GET
    @Path("getAllItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllItems(){
    	List<Item> items = itemService.getAllItems();
    	return Response.ok(items).build();
    }

}
