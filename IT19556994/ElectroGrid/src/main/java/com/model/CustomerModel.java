package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public String insertCustomer(String fname, String lname, String contact_number, String cus_email, int cus_status) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting";

			}

			// create a prepared statement
			String query = "insert into employees('fname','lname', 'contact_number', 'cus_email', 'cus_status') "
					+ "values( ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, fname);
			preparedStmt.setString(1, lname);
			preparedStmt.setString(2, contact_number);
			preparedStmt.setString(3, cus_email);
			preparedStmt.setInt(4, 1);
			

			preparedStmt.execute();
			con.close();

			output = "Values Inserted Successfully";
		} catch (Exception e) {
			output = "Error while inserting the employee";
			System.err.println(e.getMessage());
		}
		return output;

	}
	

}
