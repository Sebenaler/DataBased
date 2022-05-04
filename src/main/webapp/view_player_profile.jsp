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


<a href="./delete_player_profile.jsp?player_id=<%=request.getParameter("player_id")%>">
<button type = "button">Delete Profile</button></a>

<a href="./team_list.jsp">
<button type = "button">Back To Team List</button></a>

</body>
</html>