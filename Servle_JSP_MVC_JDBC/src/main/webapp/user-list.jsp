<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>User Management</h1>

<h3>List Of Users</h3>
<div><a href="<%=request.getContextPath() %>/new">Add New User</a></div>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Action</th>	
			</tr>		
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.email}" /></td>	
					<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>	
					&nbsp;&nbsp;&nbsp;	
					<a href="delete?id=<c:out value='${user.id}' />">Delete</a>			
				</tr>			
			</c:forEach>		
		</tbody>
	</table>

</body>

</html>
