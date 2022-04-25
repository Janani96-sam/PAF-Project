package org.payment.management.payAPI;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.payment.management.model.payment.bill;
import org.payment.management.model.payment.payment;
import org.payment.management.model.payment.paymentModel;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import com.google.gson.*;

@Path("postresource")
public class postResource {
	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResources() {
		
		
		ArrayList<bill> Bill = paymentModel.retrieveAll();
		
		JSONObject obj = new JSONObject();
		JSONArray jsArray = new JSONArray();
		
		obj.put("state","1");
		if(Bill.size() != 0) {
			System.out.println("Succesfully get all payment info!");
			
			for (int counter = 0; counter < Bill.size(); counter++) { 
				JSONObject objs = new JSONObject();
				
				objs.put("idbill", Bill.get(counter).getIdpay_bill());
				objs.put("cus_id", Bill.get(counter).getCus_id());
				objs.put("bill_no", Bill.get(counter).getBill_no());
				objs.put("month", Bill.get(counter).getMonth());
				objs.put("tot_amount", Bill.get(counter).getTot_amount());
				objs.put("status", Bill.get(counter).getStatus());
		          //System.out.println(arrlist.get(counter)); 		
				jsArray.add(objs);
		      }  
			
			obj.put("data", jsArray);
			obj.put("message", "Succesfully get all payment info !");
			
		}else {
			System.out.println("Error get all payment info !");
			obj.put("data", jsArray);
			obj.put("message", "Error get all payment info !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
    }
	
	@POST
	@Path("/def")
	@Produces(MediaType.TEXT_PLAIN)
	public String postResources() {
		return "Post method calling!";
	}
	
	
	@POST
	@Path("/deff")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String postResourcesWIthParam(@FormParam("pdCusName") String pdCusName) {
		return "Post method calling! "+pdCusName;
	}
	
	//save bill
	
	@POST
	@Path("/addPayment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAddPayemntInfo(@FormParam("customer") String customer,@FormParam("last_bill") String last_bill,@FormParam("this_bill") String this_bill,@FormParam("last_payment") String last_payment,@FormParam("unit_price") String unit_price) {
		
		payment pay = new payment();
		pay.setCus_id(customer);
		pay.setLast_bill(last_bill);
		pay.setThis_bill(this_bill);
		pay.setLast_payment(last_payment);
		pay.setUnit_price(unit_price);
		
		int state = paymentModel.payBill(pay);
		
		JSONObject obj = new JSONObject();
		
		
		obj.put("state",state);
		if(state!= 0) {
			System.out.println("Succesfully Inserted payment!");
			
			obj.put("message", "Succesfully Inserted payment !");
			
		}else {
			System.out.println("Error in Insert payment !");
			obj.put("message", "Error in Insert payment !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
		
		//return "Post method calling! coustomer "+customer+" last bill "+last_bill+" this bill "+this_bill+" last payemnt "+last_payment+" unit price "+unit_price +" staus "+state;
	}
	
	//pay bill
	
	@POST
	@Path("/payBill")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPayBillInfo(@FormParam("customer") String customer,@FormParam("bill_no") String bill_no,@FormParam("month") String month,@FormParam("amount") String amount) {
		
		bill bils = new bill();
		
		bils.setCus_id(customer);
		bils.setBill_no(bill_no);
		bils.setMonth(month);
		bils.setTot_amount(amount);
		
		int state = paymentModel.payAmount(bils);
		
		JSONObject obj = new JSONObject();
		
		
		obj.put("state",state);
		if(state!= 0) {
			System.out.println("Succesfully Inserted!");
			
			obj.put("message", "Succesfully Inserted!");
			
		}else {
			System.out.println("Error in Insert!");
			obj.put("message", "Error in Insert!");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
		//return "Post method calling! coustomer "+customer+" bill no "+bill_no+" month "+month+" amount "+amount+" status "+state;
	}
	
	//load all bill info
	
	
	//delete bill info
	@POST
	@Path("/removeBill")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPayBillInfo(@FormParam("customer") String newid) {
		
		System.out.println(" id "+newid);
		
		int id = Integer.parseInt(newid);
		boolean state = paymentModel.deleteBill(id);
		
		
		JSONObject obj = new JSONObject();
		
		
		obj.put("state",state);
		if(state) {
			System.out.println("Succesfully remove payment!");
			
			obj.put("message", "Succesfully remove payment !");
			
		}else {
			System.out.println("Error in remove payment !");
			obj.put("message", "Error in remove payment !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
		//return "Post method remove calling! bill ID "+newid+" state "+state;
	}
	
	
	//update bill status
	@POST
	@Path("/updateBill")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postUpdateBillInfo(@FormParam("newid") String newid,@FormParam("statuss") String status) {
		
		System.out.print("new "+newid+" status "+status);
		
		int id = Integer.parseInt(newid);
		int statuss = Integer.parseInt(status) == 1 ? 0 : 1; //change status
		
		//call model
		
		System.out.print("new "+newid+" update status "+statuss);
		boolean state = paymentModel.changeBillStatus(id, statuss);
		
		
		JSONObject obj = new JSONObject();
		
		
		obj.put("state",state);
		if(state) {
			System.out.println("Succesfully update payment!");
			
			obj.put("message", "Succesfully update payment !");
			
		}else {
			System.out.println("Error in update payment !");
			obj.put("message", "Error in update payment !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
		
		//return "Post method update calling! bill ID "+newid +" status "+status +" state "+state;
	}
	
	//load all data
	@POST
	@Path("/loadBill")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAllBillInfo(@FormParam("customer") String newid) {
		
		//int id = Integer.parseInt(newid);
		
		ArrayList<payment> Payment = paymentModel.retrieveAllBill(newid);
		
		//call model
		//boolean state = paymentModel.changeBillStatus(id, statuss);
		
		
		JSONObject obj = new JSONObject();
		JSONArray jsArray = new JSONArray();
		
		obj.put("state","1");
		if(Payment.size() != 0) {
			System.out.println("Succesfully get all payment info!");
			
			for (int counter = 0; counter < Payment.size(); counter++) { 
				JSONObject objs = new JSONObject();
				
				objs.put("idbill", Payment.get(counter).getIdbill());
				objs.put("cus_id", Payment.get(counter).getCus_id());
				objs.put("last_bill", Payment.get(counter).getLast_bill());
				objs.put("this_bill", Payment.get(counter).getThis_bill());
				objs.put("last_payment", Payment.get(counter).getLast_bill());
				objs.put("unit_price", Payment.get(counter).getUnit_price());
		          //System.out.println(arrlist.get(counter)); 		
				jsArray.add(objs);
		      }  
			
			obj.put("data", jsArray);
			obj.put("message", "Succesfully get all payment info !");
			
		}else {
			System.out.println("Error get all payment info !");
			obj.put("data", jsArray);
			obj.put("message", "Error get all payment info !");
		}
			
			//responseStatus = false;
		Response  response = Response.status(Status.OK).entity(obj.toString()).build();
		
		return response;
		
		
		//return "Post method update calling! bill ID "+newid +" status "+status +" state "+state;
	}
	
}
