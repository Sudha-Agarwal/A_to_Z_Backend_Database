<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="WEB-INF/custom.tld"  prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<custom:customTag />
<br />
<custom:simpleTag message="Hello from tag"/>
<br />
<custom:styledText style="color: blue;">This is a styled text</custom:styledText>
</body>
</html>