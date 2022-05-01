<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Store Items</title>
</head>
<body>
	<% SQLRoutinesIan s = new SQLRoutinesIan();
ResultSet r = s.viewStoreItems();
%>
<%while(r.next()){ %>
	<%="Item Name: " + r.getString(2) + " Item Price: " + r.getString(3) + " Item Description: " + r.getString(4)%><br>
	<%} %>
	<a href="./add_new_store_item.jsp">
	<button type="button">Add New Store Item</button>
	</a>
</body>
</html>