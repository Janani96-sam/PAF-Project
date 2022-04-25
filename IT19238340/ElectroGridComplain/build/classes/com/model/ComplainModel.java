package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pojo.Complain;
import com.validation.Validation;

public class ComplainModel {
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, user name, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/egridcondb", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String insertComplain(Complain complain) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";

			}
			if (!Validation.isPhoneNo(complain.getContact_no())) {
				return "{\"status\":\"400\",\"message\":\" Incorrect Phone Number\"}";
			}

			// create a prepared statement
			String query = "insert into complain (category,complain,status,comment,contact_no,account_profiles_accid) "
					+ "values( ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, complain.getCategory());
			preparedStmt.setString(2, complain.getComplain());
			preparedStmt.setInt(3, complain.getStatus());
			preparedStmt.setString(4, complain.getComment());
			preparedStmt.setString(5, complain.getContact_no());
			preparedStmt.setInt(6, complain.getAccount_profiles_accid());

			preparedStmt.execute();
			con.close();

			output = "{\"status\":\"200\",\"message\":\"Values Inserted Successfully\"}";
		} catch (Exception e) {

			output = "{\"status\":\"400\",\"message\":\"Error while inserting the Complain\"}";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String readComplains() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading";
			}

			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Complain ID</th><th>Customer Name</th>"
					+ "<th>Account Number</th>" + "<th>Category</th>" + "<th>complain</th>" + "<th>Mobile Number</th>"
					+ "<th>Address</th>" + "<th>Email</th>" + "<th>Description</th>" + "<th>Status</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from complain";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String comid = Integer.toString(rs.getInt("comid"));
				String accno = rs.getString("accno"); //////////////////////////
				String category = rs.getString("category");
				String complain = rs.getString("complain");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String description = rs.getString("description");

				// Add into the html table
				output += "<tr><td>" + comid + "</td>";
				output += "<td>" + accno + "</td>";
				output += "<td>" + category + "</td>";
				output += "<td>" + complain + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + mobile + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + description + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='eid' type='hidden' value='" + comid + "'>" + "</form></td></tr>";
			}
			con.close();

			// complete the html table
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while reading the employees";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String searchComplains(String name) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for searching";
			}

			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Complain ID</th><th>Customer Name</th>"
					+ "<th>Account Number</th>" + "<th>Category</th>" + "<th>complain</th>" + "<th>Mobile Number</th>"
					+ "<th>Address</th>" + "<th>Email</th>" + "<th>Description</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from complain WHERE name LIKE '%" + name + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String comid = Integer.toString(rs.getInt("comid"));
				String accno = rs.getString("accno");
				String category = rs.getString("category");
				String complain = rs.getString("complain");
				String name_1 = rs.getString("name");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String description = rs.getString("description");

				// Add into the html table
				output += "<tr><td>" + comid + "</td>";
				output += "<td>" + accno + "</td>";
				output += "<td>" + category + "</td>";
				output += "<td>" + complain + "</td>";
				output += "<td>" + name_1 + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + mobile + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + description + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='eid' type='hidden' value='" + comid + "'>" + "</form></td></tr>";
			}
			con.close();

			// complete the html table
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while searching the employees";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public ArrayList<Complain> searchComplainsJson(String name) {
		ArrayList<Complain> output = new ArrayList<Complain>();

		try {
			Connection con = connect();

			if (con == null) {
				return output;
			}
		
			String query = "select * from complain WHERE account_profiles_accid = '" + name + "'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				Complain c = new Complain();
				c.setComid(rs.getInt("comid"));
				c.setCategory(rs.getString("category"));
				c.setComplain(rs.getString("complain"));
				c.setAccount_profiles_accid(rs.getInt("account_profiles_accid"));
				c.setStatus(rs.getInt("status"));
				c.setComment(rs.getString("comment"));
				c.setContact_no(rs.getString("contact_no"));

				output.add(c);

			}
			con.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return output;

	}

	// need to modify the method parameters to employee
	public String updateComplain(Complain complain) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";

			}

			// create a prepared statement
			String query = "UPDATE complain SET status=?, comment=?  WHERE comid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			System.out.println(complain.getComid());
			System.out.println(complain.getComment());
			System.out.println(complain.getStatus());
			// binding values
			// need to modify he data types

			preparedStmt.setInt(1, complain.getStatus());
			preparedStmt.setString(2, complain.getComment());
			preparedStmt.setInt(3, complain.getComid());

			preparedStmt.execute();
			con.close();

			output = "{\"status\":\"200\",\"message\":\"Complain Update Success ! !\"}";
			;
		} catch (Exception e) {
			output = "{\"status\":\"400\",\"message\":\"Error while updating Complain !\"}";
			;
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String deleteComplain(Complain complain) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";
			}

			String query = "delete from complain where comid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			System.out.println(complain.getComid());
			// binding values
			preparedStmt.setInt(1, complain.getComid());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "{\"status\":\"200\",\"message\":\"Complain Delete Success !\"}";

		} catch (Exception e) {
			output = "{\"status\":\"400\",\"message\":\"Error while Deleting Complain !\"}";

			System.err.println(e.getMessage());
		}

		return output;
	}

}
