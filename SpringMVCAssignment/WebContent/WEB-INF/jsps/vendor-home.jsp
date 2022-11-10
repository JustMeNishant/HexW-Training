<%@page import="java.util.ArrayList"%>
<%@page import="com.spring.main.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<style>

body {
background-color: black;
}

.addbutton {
  background-color: black;
  color: white;
  padding: 5px 5px;
  text-align: center;
  display: inline-block;
  font-size: 13px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 10px;
}

.button1 {
  background-color: green;
  color: black;
  padding: 5px 5px;
  text-align: center;
  display: inline-block;
  font-size: 13px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 10px;
  width: 40%;
}
.button2 {
  background-color: red;
  color: black;
  padding: 5px 5px;
  text-align: center;
  display: inline-block;
  font-size: 13px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 10px;
  width: 40%;
}
.card {
display:inline-block;
}
</style>

</head>
<body>

<nav class="navbar navbar-expand-lg bg-secondary">
  <div class="container-fluid">
    <h4>Vendor Home</h4>
 
    <a href ="<%=request.getContextPath()%>/insertProduct-page"><button class="addbutton">Add Product</button></a><br />
  </div>
</nav>

<div class="container-fluid p-3 my-3 bg-dark text-white">
<h3>Mobiles</h3>
<%
List<Product> list = (List<Product>)request.getAttribute("list");
List<Product> mobile = new ArrayList<>();
List<Product> desktop = new ArrayList<>();

for(Product p:list){
	if(p.getCategory().equalsIgnoreCase("mobile"))
		mobile.add(p);
	else
		desktop.add(p);	
}

for(Product p:mobile){
%>
<div class="card bg-primary" style="width: 18rem;">
    <div class="card-body">
	<h4><%=p.getTitle() %></h4>
	<p>Ram:<%=p.getRam()%>,Memory:<%=p.getMemory()%></p>
	<p>Display:<%=p.getDisplay() %></p>
	&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/editproduct-page?id=<%=p.getId()%>"><button class="button1" >Edit</button></a>
	<a href="<%=request.getContextPath()%>/delete-product?id=<%=p.getId()%>"><button class="button2" >Delete</button></a><br />
  </div>
</div>
&nbsp;&nbsp;
<%
}
%>
<br />
<h3>Desktops</h3>
<% 
for(Product p:desktop){
%>
<div class="card bg-primary" style="width: 18rem;">
    <div class="card-body">
	<h4><%=p.getTitle() %></h4>
	<p>Ram:<%=p.getRam()%>,Memory:<%=p.getMemory()%></p>
	<p>Display:<%=p.getDisplay() %></p>
	&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/editproduct-page?id=<%=p.getId()%>"><button class="button1" >Edit</button></a>
	<a href="<%=request.getContextPath()%>/delete-product?id=<%=p.getId()%>"><button class="button2" >Delete</button></a><br />
  </div>
</div>
&nbsp;&nbsp;
<%
}
%>





</div>
</body>
</html>