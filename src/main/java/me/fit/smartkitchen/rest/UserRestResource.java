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

import me.fit.smartkitchen.model.User;
import me.fit.smartkitchen.service.api.UserService;

@Path("/rest")
public class UserRestResource {
	
	@Inject
	UserService userService;
	
	@Inject
	EntityManager em;
	
	@POST
	@Path("createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		userService.createUser(user);
		return Response.ok().build();
	}
	
	@POST
	@Path("updateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		userService.updateUser(user);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllUsers")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllUsers() {
		List<User> users = userService.getAllUsers();
		return Response.ok(users).build();
	}

}
