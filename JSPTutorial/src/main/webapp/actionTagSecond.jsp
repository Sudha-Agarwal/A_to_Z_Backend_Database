<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");

	if(name!= null && !name.isEmpty()){
%>
		<p>Welcome, <%=name %></p>
		<% }
	else{
	%>
	<p>No name parameter</p>
	<%} %>
	

</body>
</html>