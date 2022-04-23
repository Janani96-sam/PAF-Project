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

import com.electrogrid.model.Interruption;
import com.electrogrid.service.InterruptionService;


@Path("myresource")
public class InterruptionResource {
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createInterruption(Interruption interruption) throws ClassNotFoundException, SQLException {
		
	    Interruption createInterruption = InterruptionService.createInterruption(interruption);
	    if(createInterruption != null) {
	    	return Response.status(Status.CREATED).entity(createInterruption).build();
	    }
	    else {
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
	    }
	}
	
	
	    
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
		public Response getInterruption() throws ClassNotFoundException, SQLException{
	    	
	    	if(InterruptionService.getInterruptions().isEmpty()) {
	    		return Response.status(Status.NOT_FOUND).entity("No Interruptions Found").build();
	    	}
	    	else {
	    		return Response.status(Status.OK).entity(InterruptionService.getInterruptions()).build();
	    	}
	    	
		}
	    
	    
	    @Path("/update/{id}")
		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateInterruption(Interruption interruption,@PathParam("id") int intId) throws ClassNotFoundException, SQLException {
			
			if(interruption != null) {
				if(InterruptionService.updateInterruption(interruption,intId) != null) {
					return Response.status(Status.OK).entity(InterruptionService.updateInterruption(interruption,intId)).build();
				}
				else {
					return Response.status(Status.NOT_FOUND).entity("No Related Interruptions Found").build();
				}
			}
			else {
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
			}
			
		}
	    
	    
	    @DELETE
		@Path("/delete/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response deleteInterruption(@PathParam("id") int intId) throws ClassNotFoundException, SQLException{
			 
			if(!InterruptionService.deleteInterruption(intId)) {
				return Response.status(Status.OK).entity(intId).build();
			}
			else {
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
			}
		    	
		}	
		
}
