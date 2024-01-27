<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>List of Users</h1>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Country</th>
			<th>Action</th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach var ="user" items="${listUser}">
		<tr>
			<td><c:out value="${user.id }" /></td>
		
		</tr>
		
		</c:forEach>
	
	</tbody>


</table>
</body>
</html>