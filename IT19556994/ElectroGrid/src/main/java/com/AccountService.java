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
import com.model.AccountModel;
import com.pojo.Account;

@Path("/account_profile")
public class AccountService {
	@GET
	@Path("/viewaccounts") // employee end point
	@Produces(MediaType.TEXT_HTML)
	public String viewAccount() {
		AccountModel cus = new AccountModel();
		String output = cus.readAccounts();

		return output;
	}

	@GET
	@Path("/{id}/searchAccounts") // employee end point
	@Produces(MediaType.APPLICATION_JSON)
	public String searchAccounts(@PathParam("id") int id) {
		AccountModel acc = new AccountModel();
		//String output = acc.searchAccounts(id);
		ArrayList<Account> al = acc.searchAccountsJson(id);
		Gson gson = new Gson();
		String output = gson.toJson(al);
		return output;
	}

	@POST
	@Path("/insertaccounts") // account end point
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertAccounts(String json) {
		AccountModel acc = new AccountModel();
		Gson gson = new Gson();
		Account acct = gson.fromJson(json, Account.class);
		String output = acc.insertAccount(acct);

		return output;
	}
	
	@PUT
	@Path("/updateaccount")
	@Produces(MediaType.APPLICATION_JSON) //type that we send (response type)
	@Consumes(MediaType.APPLICATION_JSON) // type that we receive (request type)
	public String updateAccount(String json) {
		AccountModel acc = new AccountModel();
		Gson gson = new Gson();
		Account acct = gson.fromJson(json, Account.class);
		String output = acc.updateAccount(acct);
		
		return output;
	}
	
	@DELETE
	@Path("/deleteaccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAccountr(String json) {
		AccountModel acc = new AccountModel();
		Gson gson = new Gson();
		Account acct = gson.fromJson(json, Account.class);
		String output = acc.deleteAccount(acct);
		return output;
		
		
	}
	
}
	