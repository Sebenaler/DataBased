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
ResultSet result = s.viewPlayerProfile(request.getParameter("player_id"));
%>
<% while (result.next()){    %>
	<%=result.getString(1)%><br>
	<%=result.getString(2)%><br>
	<%=result.getString(3)%><br>
	<%=result.getString(4)%><br>
	<%=result.getString(5)%><br>
	<%=result.getString(6)%><br>
	<%=result.getString(7)%><br>
	<%} %>
</body>
</html>