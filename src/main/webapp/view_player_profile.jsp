<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Player Profile</title>
</head>
<body>
	<% SQLRoutinesIan s = new SQLRoutinesIan();
String r = s.viewPlayerProfile("05");
%>
	<%=r %>
		<a href="./edit_profile.jsp"> 
	<button type="button">Edit Profile</button>
	</a>
</body>
</html>