<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Store Item</title>
</head>
<body>
<%if (request.getAttribute("Message") != null){%>
<h3><%=request.getAttribute("Message")%></h3>
<%} %>
<form action = "uploadServlet" method = "POST" enctype="multipart/form-data">
         Item Number: <input type = "text" name = "item_number">
         <br />
         Item Name: <input type = "text" name = "item_name">
         <br />
         Item Price: <input type = "text" name = "item_price">
         <br />
         Item Description: <input type = "text" name = "item_desc">
         <br />
         Quantity: <input type = "text" name = "item_quantity" />
         <br>
         Image File: <input type="file" name="photo" size="50"/>
         <br>
         Image Name: <input type = "text" name = "image_name" />
         <input type = "submit" value = "Submit" />
      </form>
<a href="./view_store.jsp">
<Button type="button"> Back to Store</button> 
</a>
</body>
</html>