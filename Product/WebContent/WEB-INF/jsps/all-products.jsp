<%@page import="com.spring.main.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<br></br>
<style type="text/css">
body {
	background: linear-gradient(to bottom left, #333300 0%, #cc0000 100%);
	margin: 0 auto;
	width: fit-content;
	color:white;
}

div {
	text-align: center;
	border: 3px solid #101;
	border: 1px solid purple;
	border-radius: 10px;
	height: fit-content;
	width: fit-content;
}
.pro_block {
	display: inlibe-block;
	border: 3px solid white;
	padding: 15px;
	height: fit-content;
	width: fit-content;
	padding-bottom: 2%;
	float: left;
	margin: 10px;
	background: linear-gradient(to top right, #333300 0%, #cc0000 100%);
	font-family: Georgia, serif;
	font-size: 1vw;
}

.pro_block_mobile {
	display: inlibe-block;
	border: 3px solid white;
	padding: 15px;
	height: fit-content;
	width: fit-content;
	padding-bottom: 2%;
	float: left;
	margin: 10px;
	background: linear-gradient(to bottom left, #333300 0%, #cc0000 100%);
	font-family: Georgia, serif;
	font-size: 1vw;
}

.pro_block_laptop {
	display: inlibe-block;
	border: 3px solid white;
	padding: 15px;
	height: fit-content;
	width: fit-content;
	padding-bottom: 2%;
	float: left;
	margin: 10px;
	background: linear-gradient(to bottom left, #333300 0%, #cc0000 100%);
	font-family: Georgia, serif;
	font-size: 1vw;
}

.addbutton {
	background color: black;
	color: white; padding 5px 5px;
	text-align: center;
	font-size: 13px;
	margin: 4px 2px;
	display: inline-block;
	cursor: pointer;
	border-radius: 7px;
	p
}

.button1 {style="background-color: #ff0066;
	background color: red;
	color: white; padding 5px 5px;
	text-align: center;
	font-size: 0.75vw;
	margin: 4px 2px;
	display: inline-block;
	cursor: pointer;
	border-radius: 7px;
	width: fit-content;
	height: fit-content;
}
.button2 {
	background color: red;
	color: red; padding 5px 5px;
	text-align: center;
	font-size: .75vw;
	margin: 4px 2px;
	display: inline-block;
	cursor: pointer;
	border-radius: 7px;
	width: fit-content;
	height: fit-content;
}

.pro_block_tablet {
	display: inlibe-block;
	border: 3px solid white;
	padding: 15px;
	height: fit-content;
	width: fit-content;
	padding-bottom: 2%;
	float: left;
	margin: 10px;
	background: linear-gradient(to bottom left, #333300 0%, #cc0000 100%);
	font-family: Georgia, serif;
	font-size: 1vw;
}
</style>

</head>
<body>


	<h1>
		<a href="info" style="color:white;">Vendor Home </a> &nbsp;

	
		<a href="addedit" style="color:white;">Add Product </a> <br> </br>

		<%
			List<Product> list = (List<Product>) request.getAttribute("list");
			List<Product> mobile = new ArrayList<>();
			List<Product> laptop = new ArrayList<>();
			List<Product> tablet = new ArrayList<>();
			for (Product p : list) {
				if (p.getCategory().equalsIgnoreCase("Mobile")) {
					mobile.add(p);
				}
			}
			for (Product p : list) {
				if (p.getCategory().equalsIgnoreCase("Laptop")) {
					laptop.add(p);
				}
			}
			for (Product p : list) {
				if (p.getCategory().equalsIgnoreCase("Tablet")) {
					tablet.add(p);
				}
			}

			Product product = (Product) request.getAttribute("product");
		%>

<div class="pro_block">
		<h8 style="float:left">Mobiles</h8>
		<br></br>
		<%
			Boolean ans1 = mobile.isEmpty();
		%>
		<%
			if (ans1 == true) {
		%>
		<div class="pro_block_tablet">
			<h3>No Mobile In Stock</h3>
		</div>
		<%
			}
		%>
		<%
			for (Product e : mobile) {
		%>

		<div class="pro_block_mobile">
			<h3><%=e.getName()%></h3><%=e.getDescrip()%>&nbsp;<br></br>INR
			<%=e.getPrice()%>&nbsp; <br></br> <a
				href="<%=request.getContextPath()%>/delete-product?id=<%=e.getId()%>"
				onclick='return confirm("Are you sure you want to delete?")'><button class="button1" style="background-color: #ff0006;">
					<b>Delete</b>
				</button></a> <a href="addedit"><button class="button2" style="background-color: white;"><b>Edit</b></button> </a>

		</div>
		
		&nbsp;&nbsp;
		<%
			}
		%>
</div>

		<br></br> <br></br> <br></br><br></br>
<div class="pro_block">
		<h8 style="float:left">Laptops</h8>
		<br></br>
		<br></br>
		<%
			Boolean ans2 = laptop.isEmpty();
		%>
		<%
			if (ans2 == true) {
		%>
		<div class="pro_block_tablet">
			<h3>No Laptop In Stock</h3>
		</div>
		<%
			}
		%>
		<%
			for (Product e : laptop) {
		%>

		<div class="pro_block_laptop">

			<h3><%=e.getName()%></h3><%=e.getDescrip()%>&nbsp;<br></br>INR
			<%=e.getPrice()%>&nbsp; <br></br> <a
				href="<%=request.getContextPath()%>/delete-product?id=<%=e.getId()%>"
				onclick='return confirm("Are you sure you want to delete?")'><button class="button1" style="background-color: #ff0006;">
					<b>Delete</b>
				</button></a> <a href="addedit"><button class="button2" style="background-color: white;"><b>Edit</b></button> </a>

</div>
		
		&nbsp;&nbsp;
		<%
			}
		%>
</div>

		<br></br> 
<div class="pro_block">
			<h8 style="float:left">Tablets</h8>
			<br></br>
			<%
				Boolean ans = tablet.isEmpty();
			%>
			<%
				if (ans == true) {
			%>
			<div class="pro_block_tablet">
				<h3>No Tablet In Stock</h3>
			</div>
			<%
				}
			%>

			<%
				for (Product e : tablet) {
			%>

			<div class="pro_block_tablet" >
<h3><%=e.getName()%></h3><%=e.getDescrip()%>&nbsp;<br></br>INR
			<%=e.getPrice()%>&nbsp; <br></br> <a
				href="<%=request.getContextPath()%>/delete-product?id=<%=e.getId()%>"
				onclick='return confirm("Are you sure you want to delete?")'><button class="button1" style="background-color: #ff0006;">
					<b>Delete</b>
				</button></a> <a href="addedit"><button class="button2" style="background-color: white;"><b>Edit</b></button> </a>

			</div>
			<%
				}
			%><br></br>
			</div>
			<br></br>
			<h6 style="float: left">Nishant</h6>

</body>
</html>