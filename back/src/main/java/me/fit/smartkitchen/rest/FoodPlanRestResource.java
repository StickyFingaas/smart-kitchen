package me.fit.smartkitchen.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.fit.smartkitchen.model.FoodPlan;
import me.fit.smartkitchen.service.api.FoodPlanService;

@Path("/rest")
public class FoodPlanRestResource {

	@Inject
	FoodPlanService foodPlanService;

	@Inject
	EntityManager em;
	
	@POST
	@Path("createFoodPlan")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createFoodPlan(FoodPlan foodPlan) {
		try {
			foodPlanService.createFoodPlan(foodPlan);

		}
		catch (Exception e) {
            return Response.ok(e).build();
        }
        return Response.ok().build();
    }
    
    @PUT
    @Path("updateFoodPlan")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFoodPlan(FoodPlan foodPlan) {
    	foodPlanService.updateFoodPlan(foodPlan);
    	return Response.ok().build();
    }
    
    @DELETE
    @Path("destroyFoodPlan")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response destroyFoodPlan(FoodPlan foodPlanId){
    	foodPlanService.destroyFoodPlan(foodPlanId);
    	return Response.ok().build();
    }
    
    @GET
    @Path("getFoodPlans")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllFoodPlans(){
    	List<FoodPlan> foodPlans = foodPlanService.getAllFoodPlans();
    	return Response.ok(foodPlans).build();
    }
    
}
