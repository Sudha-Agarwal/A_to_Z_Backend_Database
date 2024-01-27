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

<c:set var = "x" value="11" />
<c:out value = "${x}" />

<c:out value="${x % 2 eq 0? 'even':'odd' }" />

<c:forEach var="i" begin="1" end="5">
<p> Vlaue of i: <c:out value="${i }"/></p>
</c:forEach>
<c:if test="${x ==11 }">
<p>X is equal to 11</p>
</c:if>

<c:choose>
	<c:when test="${x < 10 }">
	<p> X is less than 10</p>
	</c:when>
	
	<c:when test="${x == 10 }">
	<p> X is equal to 10</p>
	</c:when>
	
	<c:when test="${x > 10 }">
	<p> X is greater to 10</p>
	</c:when>	

</c:choose>

<c:catch var="catchEx">
<% int x = 2/10; %>
</c:catch>

<c:if test="${catchEx != null }">
<p>Exception caught ${catchEx.message }</p>
</c:if>


</body>
</html>