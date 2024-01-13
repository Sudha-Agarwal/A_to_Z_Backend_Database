<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% 
    	pageContext.setAttribute("requestAttribute", "value in request scope", pageContext.APPLICATION_SCOPE);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//pageContext.forward("targetPage.jsp");
%>

<%response.sendRedirect("targetPage.jsp"); %>
</body>
</html>