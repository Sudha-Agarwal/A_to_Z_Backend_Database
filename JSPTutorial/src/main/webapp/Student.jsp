<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Information</h1>

<jsp:useBean id="student" class="com.example.Student" scope="session" />

<jsp:setProperty property="id" name="student" value="101"/>
<jsp:setProperty property="name" name="student" value="ABC"/>
<jsp:setProperty property="grade" name="student" value="89.9"/>

<%--Printing property values --%>
<p>ID: <jsp:getProperty property="id" name="student"/></p>

<%-- Redirecting to another JSP --%>

<%
response.sendRedirect("studentAnotherPage.jsp");
	//request.getRequestDispatcher("studentAnotherPage.jsp").include(request,response);
%>

	


</body>
</html>