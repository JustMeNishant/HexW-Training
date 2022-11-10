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
<h1>&nbsp;&nbsp;Add Product</h1>
&nbsp;
<div class="card bg-secondary" style="width: 19rem;">
    <div class="card-body">
<div class="form_1">
	<form action="<%=request.getContextPath() %>/insert-product" method="get">
	
		<label>Title: </label> 
		<input type="text" name="title">
		<br /><br />
		
		<label>Ram: </label> 
		<input type="number" name="ram">
		<br /><br />
		
		<label>Memory: </label> 
		<input type="number" name="memory">
		<br /><br />

		<label>Display: </label> 
		<input type="text" name="display">
		<br /><br />		
		
		<label>Category: </label> 
		<select  name="category" id="cars">
		  <option value="">-select-</option>
		  <option value="mobile">Mobile</option>
		  <option value="desktop">Desktop</option>
		</select>
		<br /><br />
		
		<label>Price: </label> 
		<input type="number" name="price">
		<br /><br />
		
		<input type="submit" value="Add Product">
	</form>
</div>
</div>
</div>
</body>
</html>