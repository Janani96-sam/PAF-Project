package com.electrogrid.service;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.electrogrid.model.Consumption;

public class ConsumptionInterService {
	
	
	public List<Consumption> retrieveAllAccounts() {
		
		Client client = ClientBuilder.newClient();
	    
		List<Consumption> consumptions =
	            client.target("http://localhost:8080/customer/webapi/Customer")
	            .path("all")
	            .request(MediaType.APPLICATION_JSON)
	            .get(new GenericType<List<Consumption>>() {
	            });
	    return consumptions;
	    
	}

}
