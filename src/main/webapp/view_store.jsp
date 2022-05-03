<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.util.stream.*"%>

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
	<%="Item Name: " + r.getString(2) + " Item Price: " + r.getString(3) + " Item Description: " + r.getString(4)  %>
	<img src="./image?id=<%= r.getString(1) %>" alt="<%= r.getString(2) %>" width="200" height ="200"/><br>
	<%//BufferedImage img = ImageIO.read(new InputStreamReader());
	} %>
	<a href="./add_new_store_item.jsp">
	<button type="button">Add New Store Item</button>
	</a>
</body>
</html>