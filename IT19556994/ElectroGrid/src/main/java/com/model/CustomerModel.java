package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.pojo.Customer;

public class CustomerModel {
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, user name, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/egriddb", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public String insertCustomer(Customer cus) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting";

			}

			// create a prepared statement
			String query = "insert into employees('title','fname','lname','cus_nic', 'contact_number','address', 'cus_email', 'cus_status') "
					+ "values( ?, ?, ?, ?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, cus.getTitle());
			preparedStmt.setString(2, cus.getFname());
			preparedStmt.setString(3, cus.getLname());
			preparedStmt.setString(4, cus.getCus_nic());
			preparedStmt.setString(5,cus.getContact_number() );
			preparedStmt.setString(6, cus.getAddress());
			preparedStmt.setString(7, cus.getCus_email());
			preparedStmt.setInt(8, 1);
			

			preparedStmt.execute();
			con.close();

			output = "Values Inserted Successfully";
		} catch (Exception e) {
			output = "Error while inserting the employee";
			System.err.println(e.getMessage());
		}
		return output;

	}
	
	public String readCustomers() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading";
			}

			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Employee ID</th><th>Employee Name</th>" + "<th>Mobile</th>"
					+ "<th>Email</th>" + "<th>Status</th><th>User Name</th>" + "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from employee";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String eid = Integer.toString(rs.getInt("eid"));
				String ename = rs.getString("ename");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String status = rs.getString("status");
				String emp_username = rs.getString("emp_username");

				// Add into the html table
				output += "<tr><td>" + eid + "</td>";
				output += "<td>" + ename + "</td>";
				output += "<td>" + mobile + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + status + "</td>";
				output += "<td>" + emp_username + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='eid' type='hidden' value='" + eid + "'>" + "</form></td></tr>";
			}
			con.close();

			// complete the html table
			output += "</table></body>"
					+ "</html>";

		} catch (Exception e) {
			output = "Error while reading the employees";
			System.err.println(e.getMessage());
		}
		return output;

	}
	

}
