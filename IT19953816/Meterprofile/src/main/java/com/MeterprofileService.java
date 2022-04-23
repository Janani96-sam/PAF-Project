package com;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

import com.pojo.Meterprofile;
import com.dao.MeterprofileDao;

@Path("meterprofile")
public class MeterprofileService {
	
	MeterprofileDao mDao = new MeterprofileDao();
	
	@GET
	@Path("/read")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	 {
	 return mDao.selectAllMeterprofile();
	 } 
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insert(@FormParam("id") String id,
			 @FormParam("name") String name,
			 @FormParam("connection_type") String connection_type,
			 @FormParam("estimated_power_consumption") String estimated_power_consumption,
			 @FormParam("owner") String owner,
			 @FormParam("initialized_date") String initialized_date,
			 @FormParam("initialized_emp") String initialized_emp,
			 @FormParam("location") String location)
	 {
		Meterprofile m = new Meterprofile(id,name,connection_type,estimated_power_consumption,owner,initialized_date,initialized_emp,location);
		mDao.registerMeterprofile(m);
		return "wow nice meter you got there";
	 }
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(String meterDetails) {
		
		JsonObject iobj = new JsonParser().parse(meterDetails).getAsJsonObject(); 
		
		String id = iobj.get("id").getAsString();
		String name = iobj.get("name").getAsString();
		String connection_type = iobj.get("connection_type").getAsString();
		String estimated_power_consumption = iobj.get("estimated_power_consumption").getAsString();
		String owner = iobj.get("owner").getAsString();
		String initialized_date = iobj.get("initialized_date").getAsString();
		String initialized_emp = iobj.get("initialized_emp").getAsString();
		String location = iobj.get("location").getAsString();
		Meterprofile m = new Meterprofile(id,name,connection_type,estimated_power_consumption,owner,initialized_date,initialized_emp,location);
		String r = mDao.updateMeterprofile(m);
		
		return r;
		
	}
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.TEXT_HTML)
	public String delete(String meterDetails) {
		System.out.println("Here at service");
		Document doc = Jsoup.parse(meterDetails, "", Parser.xmlParser());
		String id = doc.select("id").text();
		System.out.println(id);
		String output = Integer.toString(mDao.deleteMeterprofile(id)); 
		return output;
	}
	/*public Meterprofile getit() {
		System.out.println("get it ....");
		Meterprofile meter = new Meterprofile("01", "01", "01", "01", "01", "01", "01", "01");
		return meter;
	}*/
}
