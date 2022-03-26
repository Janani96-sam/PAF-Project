package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pojo.Account;



public class AccountModel {
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.my.sql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/egriddb", "root", "1234");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String insertAccount(Account acc) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting";
			}

			// create a prepared statement
			String query = "insert into account_profiles('serial', 'install_date', 'register_date', 'connection_type','address','status')"
					+ "values(?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding the values
			preparedStmt.setString(1, acc.getSerial());
			preparedStmt.setString(2, acc.getInstall_date());
			preparedStmt.setString(3, acc.getRegister_date());
			preparedStmt.setString(4, acc.getConnection_type());
			preparedStmt.setString(5, acc.getAddress());
			preparedStmt.setInt(6, 1);

			preparedStmt.execute();
			con.close();

			output = "Values Inserted Successfully";
		} catch (Exception e) {
			output = "Error while inserting the account details";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readAccounts() {
		String output = "";
		
		try {
			Connection con = connect();
			
			if(con==null) {
				return "Error while connecting to the database for reading";
			}
			
			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				   + "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				   + "<h1>Hello World</h1><table border='1'><tr><th>Account ID</th><th>Serial</th><th>Install Date</th><th>Register Date</th>"
				   + "<th>Connection Type</th><th>Address</th><th>Address</th>" + "<th>Status</th>"
				   + "<th>Update</th><th>Remove</th></tr>";
			

			String query = "select * from account_profiles";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			// iterate through the rows in the result set
			while(rs.next()) {
				String accid = Integer.toString(rs.getInt("accid"));
				String serial = rs.getString("serial");
				String install_date = rs.getString("install_date");
				String register_date = rs.getString("register_date");
				String connection_type = rs.getString("connection_type");
				String address = rs.getString("address");
				String status = rs.getString("status");
				
				// Add into the html table
				output += "<tr><td>" + accid + "</td>";
				output += "<td>" + serial + "</td>";
				output += "<td>" + install_date+ "</td>";
				output += "<td>" + register_date + "</td>";
				output += "<td>" + connection_type + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + status + "</td>";
				

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='accid' type='hidden' value='" + accid + "'>" + "</form></td></tr>";	
				
			}
			con.close();
			
			// complete the html table
			output += "</table></body>"
					+ "</html>";
			
		}catch(Exception e) {
			output = "Error while reading the account";
			System.err.println(e.getMessage());	
		}
		return output;
		
	}
	
	public String searchAccounts(int id) {
		String output = "";
		
		try {
			Connection con = connect();
			
			if(con==null) {
				return "Error while connecting to the database for searching";
			}
			
			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				   + "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				   + "<h1>Hello World</h1><table border='1'><tr><th>Account ID</th><th>Serial</th><th>Install Date</th><th>Register Date</th>"
				   + "<th>Connection Type</th><th>Address</th><th>Address</th>" + "<th>Status</th>"
				   + "<th>Update</th><th>Remove</th></tr>";
			

			String query = "select * from account_profiles WHERE accid LIKE '%" + id + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			// iterate through the rows in the result set
			while(rs.next()) {
				String accid = Integer.toString(rs.getInt("accid"));
				String serial = rs.getString("serial");
				String install_date = rs.getString("install_date");
				String register_date = rs.getString("register_date");
				String connection_type = rs.getString("connection_type");
				String address = rs.getString("address");
				String status = rs.getString("status");
				
				// Add into the html table
				output += "<tr><td>" + accid + "</td>";
				output += "<td>" + serial + "</td>";
				output += "<td>" + install_date+ "</td>";
				output += "<td>" + register_date + "</td>";
				output += "<td>" + connection_type + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + status + "</td>";
				

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='accid' type='hidden' value='" + accid + "'>" + "</form></td></tr>";	
				
			}
			con.close();
			
			// complete the html table
			output += "</table></body>"
					+ "</html>";
			
		}catch(Exception e) {
			output = "Error while reading the account";
			System.err.println(e.getMessage());	
		}
		return output;
		
	
	}
	
	public ArrayList<Account> searchAccountsJson(int id) {
		ArrayList<Account> output = new ArrayList<Account>();

		try {
			Connection con = connect();

			if (con == null) {
				return output;
			}

			String query = "select * from account_profiles WHERE accid LIKE '%" + id + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				Account acc = new Account();
				acc.setAccid(rs.getInt("accid"));
				acc.setSerial(rs.getString("serial"));
				acc.setInstall_date(rs.getString("install_date"));
				acc.setRegister_date(rs.getString("register_date"));
				acc.setConnection_type(rs.getString("connection_type"));
				acc.setAddress(rs.getString("address"));
				acc.setStatus(rs.getInt("status"));
			
				output.add(acc);
	
			}
			con.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
		return output;

	}
	

	public String updateAccount(Account acc) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating";

			}

			// create a prepared statement
			String query = "UPDATE account_profiles SET address=?,status=? WHERE accid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			
			preparedStmt.setString(1, acc.getAddress());
			preparedStmt.setInt(2, 1);
			preparedStmt.setInt(3,acc.getAccid());

			preparedStmt.execute();
			con.close();

			output = "Values Updated Successfully";
		} catch (Exception e) {
			output = "Error while updating the account profile";
			System.err.println(e.getMessage());
		}
		return output;

	}
	
	public String updateAccountbyAPI(Account acc) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating";

			}

			// create a prepared statement
			String query = "UPDATE account_profiles SET serial=?,install_date=? WHERE accid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			
			preparedStmt.setString(1, acc.getSerial());
			preparedStmt.setString(2,acc.getInstall_date());
			preparedStmt.setInt(9,acc.getAccid());

			preparedStmt.execute();
			con.close();

			output = "Values Updated Successfully";
		} catch (Exception e) {
			output = "Error while updating the account profile";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String deleteAccount(Account acc) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting";
			}

			String query = "delete from account_profile where accid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, acc.getAccid());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the account profile";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	
	
	
	
	
	
	
	
	
}
