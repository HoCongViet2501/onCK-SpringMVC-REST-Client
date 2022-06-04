<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>]

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>
			<h1>List customer</h1>
		</caption>
		<thead style="background: #CC99FF">
			<tr>
				<th>ID</th>
				<th>first name</th>
				<th>last name</th>
				<th>Email</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customers">
				<c:url var="deleteCustomer" value="/deleteCustomer">
					<c:param name="id" value="${customers.id }"></c:param>
				</c:url>
				<c:url var="updateCustomer" value="/customerFormUpdate">
					<c:param name="id" value="${customers.id }"></c:param>
				</c:url>
				<c:url var="AddCustomer" value="/showFormForAdd">
					<c:param name="id" value="${customers.id }"></c:param>
				</c:url>
				<tr>
					<td><c:out value="${customers.id }"></c:out></td>
					<td><c:out value="${customers.firstName }"></c:out></td>
					<td><c:out value="${customers.lastName }"></c:out></td>
					<td><c:out value="${customers.email }"></c:out></td>
					<td><c:out value="${customers.country.nameCountry }"></c:out></td>
					<td><a href="${updateCustomer } " style="color: orange;">Update
							customer</a> <a href="${deleteCustomer }"
						onclick="if(!(confirm('You sure you want to delete?'))) return false;"
						style="color: red">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
			
				<a href="${AddCustomer } " style="color: blue;">ADD customer</a>
			</tr>
		</tbody>
	</table>
</body>
</html>