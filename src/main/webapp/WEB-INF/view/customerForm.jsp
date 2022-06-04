<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer form</h1>
	<form:form action="saveCustomer" modelAttribute="customers" method="GET">
		<form:hidden path="id" />
		<table>
			<tbody>
				<tr>
				  <td><label>First name</label> </td>
				  <td> <form:input path="firstName"/></td>
				</tr>
				<tr>
				  <td><label>Last name</label> </td>
				  <td> <form:input path="lastName"/></td>
				</tr>
				<tr>
				  <td><label>Email</label> </td>
				  <td> <form:input path="email"/></td>
				</tr>
				<tr>
				  <td><label>Country</label> </td>
				   <td> <form:input path="country.nameCountry"/></td>
				</tr>
				<tr>
				  <td></td>
				  <td> <input type="submit" value="Save" class="save"> </td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>