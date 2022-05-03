<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Searched For Player</title>
</head>
<body>
<h1>Players: </h1>
	<% SQLRoutinesPeyton p = new SQLRoutinesPeyton();
	String id = request.getParameter("ID");
	String last = request.getParameter("last");
	String first = request.getParameter("first");
	String email = request.getParameter("email");
	String year = request.getParameter("year");
	String IGN = request.getParameter("IGN");
	
	%>
	<%= "-"+id+","+last+"-" %>
	
	

</body>
</html>