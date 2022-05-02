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
	<h3>First Name:</h3><%=result.getString(1)%><br>
	<h3>Last Name:</h3><%=result.getString(2)%><br>
	<h3>Email:</h3><%=result.getString(3)%><br>
	<h3>Year:</h3><%=result.getString(4)%><br>
	<h3>Description:</h3><%=result.getString(5)%><br>
	<h3>Socials:</h3><%=result.getString(6)%><br>
	<h3>IGN:</h3><%=result.getString(7)%><br>
	
	<%} %>
<a href="./edit_profile.jsp"></a>
<button type="button">Edit Profile</button>
<h3>Delete Player</h3>
<a href="./delete_player_profile.jsp?playerID=<%=request.getParameter("player_id")%>"></a>
<button type = "button">Edit Profile</button>
</body>
</html>