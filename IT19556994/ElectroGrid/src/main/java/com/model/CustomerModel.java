package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
			String query = "insert into customers('title','fname','lname','cus_nic', 'contact_number','address', 'cus_email', 'cus_status') "
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
			output = "Error while inserting the customers";
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
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Customer ID</th><th>Title</th><th>First Name</th><th>Last Name</th>"
					+ "<th>NIC</th><th>Contact Number</th><th>Address</th>" + "<th>Email</th>" + "<th>Status</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from customers";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String cid = Integer.toString(rs.getInt("cid"));
				String title = rs.getString("title");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String cus_nic = rs.getString("cus_nic");
				String contact_number = rs.getString("contact_number");
				String address = rs.getString("address");
				String cus_email = rs.getString("cus_email");
				String cus_status = rs.getString("cus_status");

				// Add into the html table
				output += "<tr><td>" + cid + "</td>";
				output += "<td>" + title + "</td>";
				output += "<td>" + fname + "</td>";
				output += "<td>" + lname + "</td>";
				output += "<td>" + cus_nic + "</td>";
				output += "<td>" + contact_number + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + cus_email + "</td>";
				output += "<td>" + cus_status + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='cid' type='hidden' value='" + cid + "'>" + "</form></td></tr>";
			}
			con.close();

			// complete the html table
			output += "</table></body>"
					+ "</html>";

		} catch (Exception e) {
			output = "Error while reading the customers";
			System.err.println(e.getMessage());
		}
		return output;

	}
	
	public String searchCustomers(String name) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for searching";
			}

			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Customer ID</th><th>Title</th><th>First Name</th><th>Last Name</th>"
					+ "<th>NIC</th><th>Contact Number</th><th>Address</th>" + "<th>Email</th>" + "<th>Status</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from customers WHERE fname LIKE '%" + name + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String cid = Integer.toString(rs.getInt("cid"));
				String title = rs.getString("title");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String cus_nic = rs.getString("cus_nic");
				String contact_number = rs.getString("contact_number");
				String address = rs.getString("address");
				String cus_email = rs.getString("cus_email");
				String cus_status = rs.getString("cus_status");
				

				// Add into the html table
				output += "<tr><td>" + cid + "</td>";
				output += "<td>" + title + "</td>";
				output += "<td>" + fname + "</td>";
				output += "<td>" + lname + "</td>";
				output += "<td>" + cus_nic + "</td>";
				output += "<td>" + contact_number + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + cus_email + "</td>";
				output += "<td>" + cus_status + "</td>";
				

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='cid' type='hidden' value='" + cid + "'>" + "</form></td></tr>";
			}
			con.close();

			// complete the html table
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while reading the customers";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public ArrayList<Customer> searchCustomersJson(String name) {
		ArrayList<Customer> output = new ArrayList<Customer>();

		try {
			Connection con = connect();

			if (con == null) {
				return output;
			}

			String query = "select * from customers WHERE fname LIKE '%" + name + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setCid(rs.getInt("cid"));
				cus.setFname(rs.getString("fname"));
				cus.setLname(rs.getString("lname"));
				cus.setCus_nic(rs.getString("cus_nic"));
				cus.setContact_number(rs.getString("contact_number"));
				cus.setAddress(rs.getString("address"));
				cus.setCus_email(rs.getString("cus_email"));
				cus.setCus_status(rs.getInt("cus_status"));
			
				output.add(cus);
	
			}
			con.close();

		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String updateCustomer(Customer cus) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating";

			}

			// create a prepared statement
			String query = "UPDATE employees SET title=?,fname=?,lname=?,cus_nic=?, contact_number=?,address=?, cus_email=?, cus_status=? WHERE cid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			// need to modify he data types

			preparedStmt.setString(1, cus.getTitle());
			preparedStmt.setString(2, cus.getFname());
			preparedStmt.setString(3, cus.getLname());
			preparedStmt.setString(4, cus.getCus_nic());
			preparedStmt.setString(5,cus.getContact_number() );
			preparedStmt.setString(6, cus.getAddress());
			preparedStmt.setString(7, cus.getCus_email());
			preparedStmt.setInt(8, 1);
			preparedStmt.setInt(9,cus.getCid());

			preparedStmt.execute();
			con.close();

			output = "Values Updated Successfully";
		} catch (Exception e) {
			output = "Error while updating the customer";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String deleteCustomer(Customer cus) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting";
			}

			String query = "delete from customers where cid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, cus.getCid());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the customer.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	

}
