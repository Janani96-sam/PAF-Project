package com.electrogrid.resource;

import java.sql.SQLException;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.electrogrid.model.Consumption;
import com.electrogrid.service.ConsumptionService;

@Path("myresource")
public class ConsumptionResource {
	
//	@GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createConsumption(Consumption consumption) throws ClassNotFoundException, SQLException {
		System.out.println(consumption);
	    Consumption createConsumption = ConsumptionService.createConsumption(consumption);
	    if(createConsumption != null) {
	    	return Response.status(Status.CREATED).entity(createConsumption).build();
	    }
	    else {
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
	    }	 
	}

}
