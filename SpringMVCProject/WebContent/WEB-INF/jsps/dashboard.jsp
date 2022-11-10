<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Dashboard</h1>
<%=request.getAttribute("list") %>

<hr>
<% 
	List<Integer> list = (List<Integer>) 
				request.getAttribute("list");

	for(int temp : list){
		out.print(temp + "<br />");
	}
%>
</body>
</html>