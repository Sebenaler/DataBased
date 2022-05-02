<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of All Teams</title>
</head>
<body>

<h1>Team List:</h1>
<h3>

<% SQLRoutinesIan s = new SQLRoutinesIan();
ResultSet result = s.viewTeams();
%>
<%while(result.next()){%>
	<%=result.getString(1)+ " " + result.getString(2) + " " + result.getString(3)%>
		<a href="./view_team_roster.jsp?team_name=<%=result.getString(1) %>"> 
	<button type="button">View Roster</button>
	</a>
		<a href="./view_team_schedule.jsp?team_name=<%=result.getString(1) %>"> 
	<button type="button">View Schedule</button>
	</a>
		<a href="./remove_team.jsp?team_name=<%=result.getString(1) %>"> 
	<button type="button">Remove Team</button>
	</a><br>
	<% }%>
	</h3>
	<a href="./add_team.jsp"> 
	<button type="button">Add Team</button>
	</a><br>
</body>
</html>