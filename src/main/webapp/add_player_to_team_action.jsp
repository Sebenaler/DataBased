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

	<% SQLRoutinesBen s = new SQLRoutinesBen();
s.addPlayerToTeam(request.getParameter("player_id"), request.getParameter("team_name"));
//request.setAttribute("team_name", request.getParameter("team_name"));
//response.sendRedirect("view_team_roster.jsp");
%>

<a href="./view_team_roster.jsp?team_name=<%=request.getParameter("team_name")%>"> 
	<button type="button">Confirm Add</button>
	</a><br>

</body>
</html>