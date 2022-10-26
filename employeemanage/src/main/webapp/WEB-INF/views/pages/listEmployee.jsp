<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<div align="center">
		<h2>Employees</h2>
		<table border="1" cellpadding="5" class="emp-table">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of birth</th>
				<th>Department</th>
				<th>Salary</th>
				<th>Manager</th>
			</tr>
			<c:forEach items="${listEmployee}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.firstname}</td>
					<td>${employee.lastname}</td>
					<td>${employee.dob}</td>
					<td>${employee.department}</td>
					<td>${employee.salary}</td>
					<td>${employee.manager}</td>
					<td><a href="edit?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp; <a href="view?id=${employee.id}">View</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>