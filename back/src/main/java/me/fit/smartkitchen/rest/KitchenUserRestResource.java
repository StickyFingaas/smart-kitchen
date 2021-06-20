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
import me.fit.smartkitchen.model.KitchenUser;
import me.fit.smartkitchen.service.api.KitchenUserService;

@Path("/rest")
public class KitchenUserRestResource {

	@Inject
	KitchenUserService kitchenUserService;

	@POST
	@Path("createKitchenUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(KitchenUser kitchenUser) {
		kitchenUserService.createKitchenUser(kitchenUser);
		return Response.ok().build();
	}

	@PUT
	@Path("updateKitchenUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(KitchenUser kitchenUser) {
		kitchenUserService.updateKitchenUser(kitchenUser);
		return Response.ok().build();
	}

	@DELETE
	@Path("deleteKitchenUserByID")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@QueryParam("id") Long id) {
		kitchenUserService.deleteKitchenUserByID(id);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllKitchenUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllKitchenUsers() {
		List<KitchenUser> kitchenUsers = kitchenUserService.getAllKitchenUsers();
		return Response.ok(kitchenUsers).build();
	}

	@GET
	@Path("getKitchenUsersByID")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getKitchenUsersByID(@QueryParam("id") Long id) {
		List<KitchenUser> kitchenUsers = kitchenUserService.getKitchenUsersByID(id);
		return Response.ok(kitchenUsers).build();
	}
	
}
