<%@page import="com.spring.main.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
		margin: 0px;
	}
	.emp_block{
		border: 1px solid #000;
		padding: 20px;
		width: 63%;
		float: left;	
		margin: 10px;
		background: gray;
		color: #fff;
		font-family: monospace;
		font-size: x-large;
	}
	.emp_block1{
		border: 1px solid #000;
		padding: 20px;
		width: 27%;
		float: left;	
		margin: 10px;
		background: gray;
		color: #fff;
		font-family: monospace;
		font-size: x-large;
	}
	
</style>
</head>
<body>
<section> 
<div class="emp_block">
	<h1>All Employees</h1>


<%
	List<Employee> list = 
	(List<Employee>)request.getAttribute("list");
	
	Employee employee = (Employee)request.getAttribute("employee");
	for(Employee e : list){
%>
	<%=e %>&nbsp;<a href="<%=request.getContextPath() %>/delete-employee?id=<%=e.getId() %>" 
		onclick='return confirm("Are you sure you want to delete?")'>delete</a>
		|&nbsp;<a href="<%=request.getContextPath() %>/edit-employee?id=<%=e.getId() %>">edit </a>
		
	<br />
<% 
	}
%>
</div>

<div class="emp_block1">
<% String flag = (String)request.getAttribute("flag");  %>
	
	<% if(flag == null) { %>
	<h3>Add Employee </h3>
	<form action="<%=request.getContextPath() %>/insert-employee" method="get">
		<label>Name: </label> 
		<input type="text" name="ename">
		<br /><br />
		<label>City: </label> 
		<input type="text" name="ecity">
		<br /><br />
		<label>Salary: </label> 
		<input type="number" name="esalary">
		<br /><br />
		<input type="submit" value="Add Employee">
	</form>
	<% }  else { %>
	<h3>Edit Employee </h3>
	<form action="<%=request.getContextPath() %>/edit-employee-op" method="get">
		<input type="hidden" name="id" value="<%=employee.getId() %>">
	 
		<label>Name: </label> 
		<input type="text" name="ename" value="<%=employee.getName() %>" readonly="readonly">
		<br /><br />
		<label>City: </label> 
		<input type="text" name="ecity" value="<%=employee.getCity() %>">
		<br /><br />
		<label>Salary: </label> 
		<input type="number" name="esalary" value="<%=employee.getSalary() %>">
		<br /><br />
		<input type="submit" value="Edit Employee">
	</form>
	<% } %>
</div>
</section>



</body>
</html>