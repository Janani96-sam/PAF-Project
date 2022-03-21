<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
if (request.getParameter("eid") != null)
{
 session.setAttribute("eid", request.getParameter("eid"));
 session.setAttribute("ename", request.getParameter("ename"));
 session.setAttribute("mobile", request.getParameter("mobile"));
 session.setAttribute("email", request.getParameter("email"));
 session.setAttribute("status", request.getParameter("status"));
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employees</title>
</head>
<body>
	<h1>Add Employees</h1>
	<form>
		Employee ID: <input name="eid" type="text"><br>
		Employee Name: <input name="ename" type="text"><br>
		Mobile: <input name="mobile" type="text"><br>
		Email: <input name="email" type="text"><br>
		Status:<input name="status" type="text"><br>
		<input name="btnSubmit" type="submit" value="Save">
		
	</form>

</body>
</html>