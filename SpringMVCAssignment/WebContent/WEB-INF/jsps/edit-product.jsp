<%@page import="com.spring.main.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<style>
body{
background-color: black;
color: white;
padding: 30px;
margin-left: 440px;
}

</style>
</head>
<body>
<%
Product p = (Product)request.getAttribute("product");
%>
<h1>&nbsp;&nbsp;Edit Product</h1>
&nbsp;
<div class="card bg-secondary" style="width: 19rem;">
    <div class="card-body">
<div class="form_1">
	<form action="<%=request.getContextPath() %>/update-product" method="get">
		
		<input type="hidden" name="id" value="<%=p.getId()%>">
		<label>Title: </label> 
		<input type="text" name="title" value="<%=p.getTitle()%>">
		<br /><br />
		
		<label>Ram: </label> 
		<input type="number" name="ram" value="<%=p.getRam() %>">
		<br /><br />
		
		<label>Memory: </label> 
		<input type="number" name="memory" value="<%=p.getMemory()%>">
		<br /><br />

		<label>Display: </label> 
		<input type="text" name="display" value="<%=p.getDisplay() %>">
		<br /><br />		
		
		<label>Category: </label> 
		<select  name="category" id="cars"> 
		  <option value="<%=p.getCategory() %>"> <%=p.getCategory() %> </option>
		  <option value="">=======</option>
		  <option value="mobile">Mobile</option>
		  <option value="desktop">Desktop</option>
		</select>
		<br /><br />
		
		<label>Price: </label> 
		<input type="number" name="price" value="<%=p.getPrice() %>">
		<br /><br />
		
		<input type="submit" value="Edit Product">
	</form>
</div>

</div>
</div>
</body>
</html>