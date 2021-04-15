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

import me.fit.smartkitchen.model.KitchenUser;
import me.fit.smartkitchen.service.api.KitchenUserService;

@Path("/rest")
public class KitchenUserRestResource {
	
	@Inject
	KitchenUserService kitchenUserService;
	
	@Inject
	EntityManager em;
	
	@POST
	@Path("createKitchenUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(KitchenUser kitchenUser) {
		kitchenUserService.createKitchenUser(kitchenUser);
		return Response.ok().build();
	}
	
	@POST
	@Path("updateKitchenUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(KitchenUser kitchenUser) {
		kitchenUserService.updateKitchenUser(kitchenUser);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllKitchenUsers")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllKitchenUsers() {
		List<KitchenUser> kitchenUsers = kitchenUserService.getAllKitchenUser();
		return Response.ok(kitchenUsers).build();
	}

}
