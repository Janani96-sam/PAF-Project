<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complaint Management System</title>
</head>
<body>
	<h1>Complaint Management</h1>
	<form>
		Account Number : <input name="accountNumber" type="text"><br>
		
		<div class="form-group">
                        <label for="category">Category</label>
                        <select name="category-select" id="category" class="form-control">
                            <option value="Breakdown">Breakdown</option>
                            <option value="ServiceRequest">Service Request</option>
                         </select>  
        </div>
		Complain : <input name="complain" type="text"><br>
		<div class="form-group">
                        <label for="Complain">Complain</label>
                        <select name="Complain-select" id="Complain" class="form-control">
                            <option value="Highvoltage">High voltage</option>
                            <option value="Meterburning">Meter burning</option>
                         </select>  
        </div>
		Name: <input name="name" type="text"><br>
		Address: <input name="address" type="text"><br>
		Mobile Phone : <input name="mobilePhone" type="text"><br>
		Land Phone: <input name="landPhone" type="text"><br>
		E-mail: <input name="email" type="text"><br>
		Description : <input name="anythingmoretotell" type="text"><br>
		<input name="btnSubmit" type"submit" value="Save">
	</form>
	
	<br>
	<table border ="1">
		<tr>
			<th>Account Number</th><th>Category</th><th>Complain</th><th>Name</th><th>Address</th><th>Mobile Phone</th><th>Land Phone</th><th>E-mail</th><th>Description</th><th>Update</th><th>Remove</th>
		</tr>
		<tr>
			<td>1234</td><td>Breakdown</td><td>Meter burning</td><td>abc</td><td>wer</td><td>0767868315</td><td>0343442330</td><td>chamodimandakini@gmail.com</td><td>eeceeyjhjthxrzzx</td>
			<td><input name="btnUpdate" type"button" value="Update"></td>
			<td><input name="btnRemove" type"button" value="Remove"></td>
		</tr>
	</table>
</body>
</html>