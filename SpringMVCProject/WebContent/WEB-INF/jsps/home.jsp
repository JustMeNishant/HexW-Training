<%@ page import="java.time.LocalDate"%>
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
out.println(LocalDate.now());
%>
<br>
<%=LocalDate.now() %>
<h1>Hello <%=request.getAttribute("username") %></h1>
<p>Age: <%=request.getAttribute("age") %></p>

<% 
int x=6;
int y=5;
int z=x+y;
%>
<div style="font-size: x-large; font-weight: bold;" >
z=<%=z %> </div>

<!-- HTML comment  --> 
<%-- JSP comment --%>
<hr>
<a href="<%=request.getContextPath() %>/employee-details">
show employee details</a>
<br>
<a href="<%=request.getContextPath() %>/dashboard">dashboard</a>
<hr>
<h3>Employee Module</h3>
<a href="<%=request.getContextPath() %>
/all-employees">All Employees</a>
</body>
</html>