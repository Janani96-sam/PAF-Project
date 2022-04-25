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
import com.model.CustomerModel;
import com.pojo.Customer;



@Path("/customer")
public class CustomerService {
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello world.";
	}

	@GET
	@Path("/viewcustomers") // customer end point
	@Produces(MediaType.TEXT_HTML)
	public String viewCustomers() {
		CustomerModel cus = new CustomerModel();
		String output = cus.readCustomers();

		return output;
	}

	@GET
	@Path("/{name}/searchCustomers")  
	@Produces(MediaType.APPLICATION_JSON)
	public String searchCustomers(@PathParam("name") String name) {
		CustomerModel cus = new CustomerModel();
		//String output = cus.searchCustomers(name);
		ArrayList<Customer> al = cus.searchCustomersJson(name);
		Gson gson = new Gson();
		String output = gson.toJson(al);
		return output;
	}

	@POST
	@Path("/insertcustomers") // customer end point
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertCustomers(String json) {
		CustomerModel cus = new CustomerModel();
		Gson gson = new Gson();
		Customer cust = gson.fromJson(json, Customer.class);
		String output = cus.insertCustomer(cust);
		System.out.println(output+"+++++++++++");

		return output;
	}
	
	@PUT
	@Path("/updatecustomer")
	@Produces(MediaType.APPLICATION_JSON) //type that we send (response type)
	@Consumes(MediaType.APPLICATION_JSON) // type that we receive (request type)
	public String updateCustomer(String json) {
		CustomerModel cus = new CustomerModel();
		Gson gson = new Gson();
		Customer cust = gson.fromJson(json, Customer.class);
		String output = cus.updateCustomer(cust);
		
		return output;
	}
	
	@DELETE
	@Path("/deletecustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCustomer(String json) {
		CustomerModel cus = new CustomerModel();
		Gson gson = new Gson();
		Customer cust = gson.fromJson(json, Customer.class);
		String output = cus.deleteCustomer(cust);
		return output;
		
		
	}
	
	// Other APIs 
	@GET
	@Path("/{id}/getcustomer") 
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerInfo(@PathParam("id") String id) {
		CustomerModel cus = new CustomerModel();
		//String output = cus.searchCustomers(name);
		Customer al = cus.getCustomersJson(id);
		Gson gson = new Gson();
		String output = gson.toJson(al);
		return output;
	}
	
	@GET
	@Path("/{id}/getcustomeraccount") 
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerInfoAccount(@PathParam("id") String id) {
		CustomerModel cus = new CustomerModel();
		//String output = cus.searchCustomers(name);
		Customer al = cus.getCustomersJsonAccount(id);
		Gson gson = new Gson();
		String output = gson.toJson(al);
		return output;
	}
	
	
	
}
