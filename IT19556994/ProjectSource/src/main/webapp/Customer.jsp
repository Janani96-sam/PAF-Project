<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
if (request.getParameter("cid") != null)
{
 session.setAttribute("cid", request.getParameter("eid"));
 session.setAttribute("fname", request.getParameter("fname"));
 session.setAttribute("lname", request.getParameter("lname"));
 session.setAttribute("contact_number", request.getParameter("contact_number"));
 session.setAttribute("address", request.getParameter("address"));
 session.setAttribute("cus_email", request.getParameter("cus_email"));
 session.setAttribute("cus_status", request.getParameter("cus_status"));
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customers</title>
</head>
<body>
	<h1>Add Customers</h1>
	<form>
		Customer ID: <input name="cid" type="text"><br>
		First Name: <input name="fname" type="text"><br>
		Last Name: <input name="lname" type="text"><br>
		Contact Number: <input name="contact_number" type="text"><br>
		Address: <input name="address" type="text"><br>
		Email: <input name="cus_email" type="text"> <br>
		Status:<input name="cus_status" type="text"><br>
		<input name="btnSubmit" type="submit" value="Save">
		
	</form>

</body>
</html>