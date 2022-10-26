<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Employee</title>
</head>
<body>
	<div align="center">
		<h2>
			<c:if test="${empty employee.id}">
			    Add
			</c:if>
			<c:if test="${not empty employee.id}">
				Edit
			</c:if>
			Employee
		</h2>
		<form:form action="save" method="post" modelAttribute="employee">
			<table border="0" cellpadding="5" class="emp-table">

				<c:if test="${not empty employee.id}">
					<tr>
						<td>ID:</td>
						<td>${employee.id}<form:hidden path="id" />
						</td>
					</tr>
				</c:if>

				<tr>
					<td>First name:</td>
					<td><form:input path="firstname" required="required" /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><form:input path="lastname" required="required" /></td>
				</tr>
				<tr>
					<td>DOB:</td>
					<td><form:input path="dob" required="required" type="date"
							 class="common-input" max="${minDate} }" />
							<form:errors path="dob" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td><form:select path="department" required="required"
							class="common-input">
							<form:option value="Customer Care">Customer Care</form:option>
							<form:option value="Finance">Finance</form:option>
							<form:option value="Audit">Audit</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><form:input type="number" path="salary" min="0"
							required="required" /></td>
				</tr>
				<tr>
					<td>Manager:</td>
					<td><form:input path="manager" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>