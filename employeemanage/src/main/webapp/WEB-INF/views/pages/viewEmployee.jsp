<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<div align="center">
		<form:form action="save" method="post" modelAttribute="employee">
			<h2> ${employee.firstname}</h2>
			<table border="1" cellpadding="5" class="emp-table">
				<tr>
					<td>ID:</td>
					<td>${employee.id}<form:hidden path="id" />
					</td>
				</tr>
				<tr>
					<td>First name:</td>
					<td>${employee.firstname}<form:hidden path="firstname" />
					</td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td>${employee.lastname}<form:hidden path="lastname" />
					</td>
				</tr>
				<tr>
					<td>Date of birth:</td>
					<td>${employee.dob}<form:hidden path="dob" />
					</td>
				</tr>
				<tr>
					<td>Department:</td>
					<td>${employee.department}<form:hidden path="department" />
					</td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td>${employee.salary}<form:hidden path="salary" />
					</td>
				</tr>
				<tr>
					<td>Manager:</td>
					<td>${employee.manager}<form:hidden path="manager" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>