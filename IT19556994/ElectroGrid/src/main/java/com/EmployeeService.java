package com;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.EmployeeModel;


@Path("/employee")
public class EmployeeService {
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello world.";
	}
	
	@GET
	@Path("/viewemployees") //employee end point
	@Produces(MediaType.TEXT_HTML)
	public String viewEmployees() {
		EmployeeModel em = new EmployeeModel();
		String output = em.readEmployees();

		return output;
	}
	
	@GET
	@Path("/{name}/searchemployees") //employee end point
	@Produces(MediaType.TEXT_HTML)
	public String searchEmployees(@PathParam("name") String name) {
		EmployeeModel em = new EmployeeModel();
		String output = em.searchEmployees(name);

		return output;
	}
	
	
	
	
	
	@POST
	@Path("/insertemployees") //employee end point
	@Produces(MediaType.TEXT_HTML)
	public String insertEmployees() {
		EmployeeModel em = new EmployeeModel();
		String output = em.readEmployees();

		return output;
	}
	

}




