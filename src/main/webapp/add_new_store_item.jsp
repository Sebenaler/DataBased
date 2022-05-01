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
	<% SQLRoutinesIan s = new SQLRoutinesIan();
boolean r = s.addNewStoreItem("0005","razer naga", 56.99, "razer naga mouse", 15);
%>
	<%=r %>
</body>
</html>