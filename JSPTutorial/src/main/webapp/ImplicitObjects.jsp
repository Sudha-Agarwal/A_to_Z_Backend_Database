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
	//Implicit Object request
	String requestMethod = request.getMethod();
	String requestURI = request.getRequestURI();
%>

<p><%= requestMethod  %></p>
<p><%= requestURI  %></p>

<% session.setAttribute("user", "Sudha"); 
	session.setMaxInactiveInterval(10);
%>

<%= application.getInitParameter("dbDriver") %>

<a href="second.jsp">Second JSP</a>

</body>
</html>