package com;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.model.EmployeeModel;
import com.pojo.Employee;

@Path("/employee")
public class EmployeeService {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello world.";
	}

	@GET
	@Path("/viewemployees") // employee end point
	@Produces(MediaType.TEXT_HTML)
	public String viewEmployees() {
		EmployeeModel em = new EmployeeModel();
		String output = em.readEmployees();

		return output;
	}

	@GET
	@Path("/{name}/searchemployees") // employee end point
	@Produces(MediaType.APPLICATION_JSON)
	public String searchEmployees(@PathParam("name") String name) {
		EmployeeModel em = new EmployeeModel();
		//String output = em.searchEmployees(name);
		ArrayList<Employee> al = em.searchEmployeesJson(name);
		Gson gson = new Gson();
		String output = gson.toJson(al);
		return output;
	}

	@POST
	@Path("/insertemployees") // employee end point
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertEmployees(String json) {
		EmployeeModel em = new EmployeeModel();
		Gson gson = new Gson();
		Employee e = gson.fromJson(json, Employee.class);
		String output = em.insertEmployee(e);

		return output;
	}
	
	@PUT
	@Path("/updateemployee")
	@Produces(MediaType.APPLICATION_JSON) //type that we send (responce type)
	@Consumes(MediaType.APPLICATION_JSON) // type that we receive (request type)
	public String updateEmployee(String json) {
		EmployeeModel em = new EmployeeModel();
		Gson gson = new Gson();
		Employee e = gson.fromJson(json, Employee.class);
		String output = em.updateEmployee(e);
		
		return output;
	}
	
	@DELETE
	@Path("/deleteemployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteItem(String json) {
		EmployeeModel em = new EmployeeModel();
		Gson gson = new Gson();
		Employee e = gson.fromJson(json, Employee.class);
		String output = em.deleteEmployee(e);
		return output;
		
		
	}
	
	
	
	
	

}
