<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Store Item Action</title>
</head>
<body>

	<% SQLRoutinesIan s = new SQLRoutinesIan();
boolean r = s.addNewStoreItem(request.getParameter("item_number"),
		request.getParameter("item_name"),
		Double.parseDouble(request.getParameter("item_price")), 
		request.getParameter("item_desc"), 
		Integer.parseInt(request.getParameter("item_quantity")));
response.sendRedirect("add_new_store_item.jsp");
%>
	<%=r %>

</body>
</html>