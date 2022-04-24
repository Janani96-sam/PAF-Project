package com;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.model.ComplainModel;
import com.pojo.Complain;

@Path("/complain")
public class ComplainService {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello Java !";
	}

	@GET
	@Path("/viewcomplains") // complain end point
	@Produces(MediaType.TEXT_HTML)
	public String viewComplains() {
		ComplainModel em = new ComplainModel();
		String output = em.readComplains();

		return output;
	}

	@GET
	@Path("/{name}/searchcomplains") // complain end point
	@Produces(MediaType.APPLICATION_JSON)
	public String searchComplains(@PathParam("name") String name) {
		ComplainModel em = new ComplainModel();
		// String output = em.searchEmployees(name);
		ArrayList<Complain> al = em.searchComplainsJson(name);
		Gson gson = new Gson();
		String output = gson.toJson(al);
		return output;
	}

	@POST
	@Path("/insertcomplains") // complain end point
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertComplain(String json) {
		ComplainModel cm = new ComplainModel();
		Gson gson = new Gson();
		Complain c = gson.fromJson(json, Complain.class);
		String output = cm.insertComplain(c);

		String response = gson.toJson(output);
		return response;
	}

	@PUT
	@Path("/updatecomplain")
	@Produces(MediaType.APPLICATION_JSON) // type that we send (responce type)
	@Consumes(MediaType.APPLICATION_JSON) // type that we receive (request type)
	public String updateComplain(String json) {
		ComplainModel cm = new ComplainModel();
		Gson gson = new Gson();
		Complain c = gson.fromJson(json, Complain.class);
		String output = cm.updateComplain(c);

		String response = gson.toJson(output);
		return response;
	}

	@DELETE
	@Path("/deletecomplain")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteItem(String json) {
		System.out.print(json);
		ComplainModel cm = new ComplainModel();
		Gson gson = new Gson();
		Complain c = gson.fromJson(json, Complain.class);
		String output = cm.deleteComplain(c);
		
		String response = gson.toJson(output);
		System.out.print(response);
		return response;

	}

}
