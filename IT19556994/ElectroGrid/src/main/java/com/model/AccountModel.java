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
			Class.forName("com.mysql.cj.jdbc.Driver");

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
				return "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";
			}
			if(acc.getSerial().length()<4) {
				return "{\"status\":\"400\",\"message\":\"Serial number  must be atleast 4 characters long !\"}";
			}

			// create a prepared statement

			String query = "insert into account_profiles (serial, install_date, register_date, connection_type,address,status,customer_cid,employee_eid) values (?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding the values
			preparedStmt.setString(1, acc.getSerial());
			preparedStmt.setString(2, acc.getInstall_date());
			preparedStmt.setString(3, acc.getRegister_date());
			preparedStmt.setString(4, acc.getConnection_type());
			preparedStmt.setString(5, acc.getAddress());
			preparedStmt.setInt(6, 0);
			preparedStmt.setInt(7, acc.getCustomer_cid());
			preparedStmt.setInt(8, acc.getEmployee_eid());

			preparedStmt.execute();

			con.close();

			output = "{\"status\":\"200\",\"message\":\"Values Inserted Successfully\"}";
		} catch (Exception e) {
			output =  "{\"status\":\"400\",\"message\":\"Error while inserting the account\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readAccounts() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
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
			while (rs.next()) {
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
				output += "<td>" + install_date + "</td>";
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
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while reading the account";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String searchAccounts(int id) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
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
			while (rs.next()) {
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
				output += "<td>" + install_date + "</td>";
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
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while reading the account";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public ArrayList<Account> searchAccountsJson(String search) {
		ArrayList<Account> output = new ArrayList<Account>();

		try {
			Connection con = connect();

			if (con == null) {
				return output;
			}

			String query = "select * from account_profiles WHERE  status= 0 AND  accid = '" + search + "' OR serial LIKE '%" + search
					+ "%' OR address LIKE '%" + search + "%'";
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
				return "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";

			}
			if(acc.getSerial().length()<4) {
				return "{\"status\":\"400\",\"message\":\"Serial number  must be atleast 4 characters long !\"}";
			}


			// create a prepared statement
			String query = "UPDATE account_profiles SET `address`=?,`status`=? WHERE accid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
//System.out.println(acc.getAccid());
			preparedStmt.setString(1, acc.getAddress());
			preparedStmt.setInt(2, acc.getStatus());
			preparedStmt.setInt(3, acc.getAccid());
			System.out.println(query);
			preparedStmt.execute();
			con.close();

			output =  "{\"status\":\"200\",\"message\":\"Updated Successfully !\"}";
		} catch (Exception e) {
			output = "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";
			System.err.println(e.getMessage());
			e.printStackTrace();
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
			preparedStmt.setString(2, acc.getInstall_date());
			preparedStmt.setInt(9, acc.getAccid());

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
				return "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";
			}

			// String query = "delete from customers where accid=?";
			String query = "UPDATE account_profiles SET status = ? where accid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 1);
			preparedStmt.setInt(2, acc.getAccid());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "{\"status\":\"200\",\"message\":\" Account Deleted Successfully !\"}";
		} catch (Exception e) {
			output = "{\"status\":\"400\",\"message\":\"Error Connecting to Database !\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

//other Api 
	public Account getAccountsJson(String id) {
		Account output = new Account();

		try {
			Connection con = connect();

			if (con == null) {
				return output;
			}

			String query = "select * from account_profile WHERE accid= '" + id + "'limit 1";
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

				output = acc;

			}
			con.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}
		return output;

	}

}
