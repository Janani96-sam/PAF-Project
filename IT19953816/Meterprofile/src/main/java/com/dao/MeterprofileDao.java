package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Meterprofile;

public class MeterprofileDao {
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","taekwon do");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public int registerMeterprofile(Meterprofile meterprofile) {
		String insert_meterprofile = "insert into electrogrid_meterprofile.meterprofile" + 
	"(id, name, connection_type,estimated_power_consumptionl, owner, initialized_date, initialized_emp, location) values" 
	+ "(?, ?, ?, ?, ?, ?, ?, ?);";
		System.out.println("registerMeterprofile");
		int result = 0;
		try {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(insert_meterprofile);
		
		preparedStatement.setString(1, meterprofile.getId());
		preparedStatement.setString(2,  meterprofile.getName());
		preparedStatement.setString(3, meterprofile.getConnection_type());
		preparedStatement.setString(4, meterprofile.getEstimated_power_consumption());
		preparedStatement.setString(5, meterprofile.getOwner());
		preparedStatement.setString(6,  meterprofile.getInitialized_date());
		preparedStatement.setString(7, meterprofile.getInitialized_emp());
		preparedStatement.setString(8,  meterprofile.getLocation());
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return result;
		
	}
	
	public List<Meterprofile> selectAllMeterprofileByUser(String user) {
		
		String output;
		
		String select_meterprofile_by_user = "select * from electrogrid_meterprofile.meterprofile where owner=?;";
		List<Meterprofile> meterprofiles = new ArrayList<>();
		Connection connection = null;
		
		//html
		output = "<table><tr><th>ID</th><th>Name</th><th>Connection Type</th>" + 
				"<th>Estimated Power consumption</th>" + 
				"<th>Owner</th><th>Initialized Date</th>" + 
				"<th>Initialized Date</th><tr>" + 
				"<th>Initialized emp</th><th>Location</th></tr>";
		
		try {
		connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(select_meterprofile_by_user);
		statement.setString(1,user);
		System.out.println(statement);
		ResultSet result = statement.executeQuery();
		
		
		while(result.next()) {
			String id = result.getString("id");
			String name = result.getString("name");
			String connection_type = result.getString("connection_type");
			String estimated_power_consumption = result.getString("estimated_power_consumptionl");
			String owner = result.getString("owner");
			String initialized_date = result.getString("initialized_date");
			String initialized_emp = result.getString("initialized_emp");
			String location = result.getString("location");
			
			meterprofiles.add(new Meterprofile(id,name,connection_type,estimated_power_consumption,owner,initialized_date,initialized_emp,location));
			
			//html
			output += "<tr><td>" + id + "</td>";
			output += "<tr><td>" + name + "</td>";
			output += "<tr><td>" + connection_type + "</td>";
			output += "<tr><td>" + estimated_power_consumption + "</td>";
			output += "<tr><td>" + owner + "</td>";
			output += "<tr><td>" + initialized_date + "</td>";
			output += "<tr><td>" + initialized_emp + "</td>";
			output += "<tr><td>" + location + "</td>";
			
			output  += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" +
						"<td><form method='post' action='items.jsp'>" +
						"<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" +
						"<input name='itemID' type='hidden' value='" 
						+ id + "'>" + "</form></td></tr>";
			
			
			
		}
		connection.close();
		//html
		output += "</table>";
		}catch(Exception e) {
			System.out.println(e);
		}
		return meterprofiles;
	}
	
	
public List<Meterprofile> selectAllMeterprofile() {
		
		String output;
		
		String select_meterprofile_by_user = "select * from electrogrid_meterprofile.meterprofile;";
		List<Meterprofile> meterprofiles = new ArrayList<>();
		Connection connection = null;
		
		//html
		output = "<table><tr><th>ID</th><th>Name</th><th>Connection Type</th>" + 
				"<th>Estimated Power consumption</th>" + 
				"<th>Owner</th><th>Initialized Date</th>" + 
				"<th>Initialized Date</th><tr>" + 
				"<th>Initialized emp</th><th>Location</th></tr>";
		
		try {
		connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(select_meterprofile_by_user);
		System.out.println(statement);
		ResultSet result = statement.executeQuery();
		
		
		while(result.next()) {
			String id = result.getString("id");
			String name = result.getString("name");
			String connection_type = result.getString("connection_type");
			String estimated_power_consumption = result.getString("estimated_power_consumptionl");
			String owner = result.getString("owner");
			String initialized_date = result.getString("initialized_date");
			String initialized_emp = result.getString("initialized_emp");
			String location = result.getString("location");
			System.out.println(id);
			meterprofiles.add(new Meterprofile(id,name,connection_type,estimated_power_consumption,owner,initialized_date,initialized_emp,location));
			
			//html
			output += "<tr><td>" + id + "</td>";
			output += "<tr><td>" + name + "</td>";
			output += "<tr><td>" + connection_type + "</td>";
			output += "<tr><td>" + estimated_power_consumption + "</td>";
			output += "<tr><td>" + owner + "</td>";
			output += "<tr><td>" + initialized_date + "</td>";
			output += "<tr><td>" + initialized_emp + "</td>";
			output += "<tr><td>" + location + "</td>";
			
			output  += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" +
						"<td><form method='post' action='items.jsp'>" +
						"<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" +
						"<input name='itemID' type='hidden' value='" 
						+ id + "'>" + "</form></td></tr>";
			
			
			
		}
		
		connection.close();
		
		//html
		output += "</table>";
		}catch(Exception e) {
			output = "Error!!!!!!!! while reading the items.";
			System.out.println(e);
		}
		return meterprofiles;
	}
	
	
	public Meterprofile selectMeterprofile(String id) throws SQLException{
		
		String output;
		
		String select_meterprofile = "select * from electrogrid_meterprofile.meterprofile where id=?;";
		Meterprofile meter=null;
		Connection connection = null;
		
		//html
		output = "<table><tr><th>ID</th><th>Name</th><th>Connection Type</th>" + 
						"<th>Estimated Power consumption</th>" + 
						"<th>Owner</th><th>Initialized Date</th>" + 
						"<th>Initialized Date</th><tr>" + 
						"<th>Initialized emp</th><th>Location</th></tr>";
				
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(select_meterprofile);
			statement.setString(1,id);
			System.out.println(statement);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				String name = result.getString("name");
				String connection_type = result.getString("connection_type");
				String estimated_power_consumption = result.getString("estimated_power_consumptionl");
				String owner = result.getString("owner");
				String initialized_date = result.getString("initialized_date");
				String initialized_emp = result.getString("initialized_emp");
				String location = result.getString("location");
				meter = new Meterprofile(id,name,connection_type,estimated_power_consumption,owner,initialized_date,initialized_emp,location);
				
				output += "<tr><td>" + id + "</td>";
				output += "<tr><td>" + name + "</td>";
				output += "<tr><td>" + connection_type + "</td>";
				output += "<tr><td>" + estimated_power_consumption + "</td>";
				output += "<tr><td>" + owner + "</td>";
				output += "<tr><td>" + initialized_date + "</td>";
				output += "<tr><td>" + initialized_emp + "</td>";
				output += "<tr><td>" + location + "</td>";
				
				
				
			}
			
			
			connection.close();
			//html
			output += "</table>";
		}catch (Exception e) {
			System.out.println(e);
		}
		return meter;
		
	}
	
	
public List<Meterprofile> selectMeterprofileByRequest() throws SQLException{
		
		String output;
		
		String select_meterprofile = "SELECT * FROM electrogrid_meterprofile.meterprofile where request_delete=1;";
		List<Meterprofile> meters=new ArrayList<>();
		Connection connection = null;
		
		//html
		output = "<table><tr><th>ID</th><th>Name</th><th>Connection Type</th>" + 
						"<th>Estimated Power consumption</th>" + 
						"<th>Owner</th><th>Initialized Date</th>" + 
						"<th>Initialized Date</th><tr>" + 
						"<th>Initialized emp</th><th>Location</th></tr>";
				
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(select_meterprofile);
			
			System.out.println(statement);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String connection_type = result.getString("connection_type");
				String estimated_power_consumption = result.getString("estimated_power_consumptionl");
				String owner = result.getString("owner");
				String initialized_date = result.getString("initialized_date");
				String initialized_emp = result.getString("initialized_emp");
				String location = result.getString("location");
				String request_delete = result.getString("request_delete");
				meters.add(new Meterprofile(id,name,connection_type,estimated_power_consumption,owner,initialized_date,initialized_emp,location,request_delete));
				
				
				output += "<tr><td>" + id + "</td>";
				output += "<tr><td>" + name + "</td>";
				output += "<tr><td>" + connection_type + "</td>";
				output += "<tr><td>" + estimated_power_consumption + "</td>";
				output += "<tr><td>" + owner + "</td>";
				output += "<tr><td>" + initialized_date + "</td>";
				output += "<tr><td>" + initialized_emp + "</td>";
				output += "<tr><td>" + location + "</td>";
				
				
				
			}
			
			
			connection.close();
			//html
			output += "</table>";
		}catch (Exception e) {
			System.out.println(e);
		}
		return meters;
		
	}
	
	
	public String updateMeterprofile(Meterprofile meter) {
		String update_meterprofile = "update electrogrid_meterprofile.meterprofile set name=?,connection_type=?,estimated_power_consumption=?,owner=?,initialized_date=?,initialized_emp=?,location=? where id=?;";
		
		int result=0;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(update_meterprofile);
			statement.setString(1, meter.getName());
			statement.setString(2, meter.getConnection_type());
			statement.setString(3, meter.getEstimated_power_consumption());
			statement.setString(4, meter.getOwner());
			statement.setString(5, meter.getInitialized_date());
			statement.setString(6, meter.getInitialized_emp());
			statement.setString(7, meter.getLocation());
			statement.setString(8, meter.getId());
			
			result = statement.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("have an error in Dao update!!!!");
			System.out.println(e);
		}
		
		return Integer.toString(result);
	}
	public int deleteMeterprofile(String id) {
		System.out.println("Here at Dao");
		String delete_meterprofile = "delete from electrogrid_meterprofile.meterprofile where id=?;";
		
		int result=0;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_meterprofile);
			statement.setString(1, id);
			result = statement.executeUpdate();
		}catch(Exception e) {
			System.out.println("Exception found in delete Dao");
			System.out.println(e);
		}
		return result;
	}

	
	
}
