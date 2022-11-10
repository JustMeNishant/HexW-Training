<%@page import="com.spring.main.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>
<%
	Employee e = (Employee)request.getAttribute("employee");
%>
<%=e %>
</body>
</html>