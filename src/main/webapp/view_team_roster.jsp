<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Team Roster</title>
</head>
<body>
<h1>Team Roster For: <%=request.getParameter("team_name") %></h1>
	<h3>
	<% SQLRoutinesIan s = new SQLRoutinesIan();
ResultSet result = s.viewTeamRoster(request.getParameter("team_name"));
%>
		<% while (result.next()){    %>
    	<%=result.getString(1) + " " + result.getString(2)%>
      	<a href="./remove_player_from_team.jsp?player_id=<%=result.getString(3)%>"> 
	<button type="button">Remove Player</button>
	</a>
		<a href="./view_player_profile.jsp?player_id=<%=result.getString(3) %>"> 
	<button type="button">View Profile</button>
	</a><br>
    <%}%>

	</h3>
</body>
</html>