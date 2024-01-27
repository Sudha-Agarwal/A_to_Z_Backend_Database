<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" info="composed by Sudha"%>
    
    <%@ page buffer="16kb" session="false" errorPage="errorHandler.jsp" isThreadSafe="false"%>
    
    <%@ include file="login.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello World</h1>

<%-- Scriptlet tag --%>
<% out.println(2*5); %>

<%
	int number = 10;
	if(number > 0){
		out.println("Number is positive");
	}
	
	for(int i=0;i<5;i++){
		out.println(i + "<br>");
	}
%>

<%-- Expression tag --%>
<% String greeting = "Hello"; %>
<%=greeting %>

<%--Declaration tag --%>

<%!
	private int counter = 0;

	public void increment(){
		counter++;
	}

%>

<%= new Date() %>
<%--<% int result = 10/0; --%>

</body>
</html>