package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pojo.Employee;

public class EmployeeModel {
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

	public String insertEmployee(Employee employee) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting";

			}

			// create a prepared statement
			String query = "insert into employees(ename,date_of_birth,emp_nic,gender, mobile, email, status, emp_username, emp_password) "
					+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, employee.getEname());
			preparedStmt.setString(2, employee.getDate_of_birth());
			preparedStmt.setString(3, employee.getEmp_nic());
			preparedStmt.setString(4, employee.getGender());
			preparedStmt.setString(5, employee.getMobile());
			preparedStmt.setString(6, employee.getEmail());
			preparedStmt.setInt(7, 1);
			preparedStmt.setString(8, employee.getEmp_username());
			preparedStmt.setString(9, employee.getEmp_password());

			preparedStmt.execute();
			con.close();

			output = "Values Inserted Successfully";
		} catch (Exception e) {
			output = "Error while inserting the employee";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String readEmployees() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading";
			}

			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Employee ID</th><th>Employee Name</th>"
					+ "<th>Mobile</th>" + "<th>Email</th>" + "<th>Status</th><th>User Name</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from employees";
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
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while reading the employees";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String searchEmployees(String name) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for searching";
			}

			// prepare the html table to be displayed
			output = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "<h1>Hello World</h1><table border='1'><tr><th>Employee ID</th><th>Employee Name</th>"
					+ "<th>Mobile</th>" + "<th>Email</th>" + "<th>Status</th><th>User Name</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from employee WHERE ename LIKE '%" + name + "%'";
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
			output += "</table></body>" + "</html>";

		} catch (Exception e) {
			output = "Error while searching the employees";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public ArrayList<Employee> searchEmployeesJson(String name) {
		ArrayList<Employee> output = new ArrayList<Employee>();

		try {
			Connection con = connect();

			if (con == null) {
				return output;
			}

			String query = "select * from employees WHERE ename LIKE '%" + name + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				Employee e = new Employee();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setMobile(rs.getString("mobile"));
				e.setDate_of_birth(rs.getString("date_of_birth"));
				e.setEmp_nic(rs.getString("emp_nic"));
				e.setEmail(rs.getString("email"));
				e.setGender(rs.getString("gender"));
				e.setEmp_username(rs.getString("emp_username"));
				e.setStatus(rs.getInt("status"));
				output.add(e);
	
			}
			con.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
		return output;

	}

	// need to modify the method parameters to employee
	public String updateEmployee(Employee employee) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating";

			}

			// create a prepared statement
			String query = "UPDATE employees SET ename=?, emp_nic=?,mobile=?,email=?,status=? WHERE eid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			// need to modify he data types

			preparedStmt.setString(1, employee.getEname());
			preparedStmt.setString(2, employee.getEmp_nic());
			preparedStmt.setString(3, employee.getMobile());
			preparedStmt.setString(4, employee.getEmail());
			preparedStmt.setInt(5, employee.getStatus());
			preparedStmt.setInt(6, employee.getEid());

			preparedStmt.execute();
			con.close();

			output = "Values Updated Successfully";
		} catch (Exception e) {
			output = "Error while updating the employee";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String deleteEmployee(Employee employee) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting";
			}

			String query = "delete from employees where eid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, employee.getEid());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the employee.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
