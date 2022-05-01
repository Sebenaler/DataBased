<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Team Schedule</title>
</head>
<body>
<h1>Team Schedule For: <%=request.getParameter("team_name") %></h1>
	<h3>
	<% SQLRoutinesBen s = new SQLRoutinesBen();
ResultSet result = s.viewTeamSchedule(request.getParameter("team_name"));
%>
		<% while (result.next()){    %>
    	<%=result.getString(1) + " " + result.getString(2) + " " + result.getDate(3) + " " + result.getString(4) + " " + result.getString(5) + " " + result.getString(6)%><br>
      
    <%}%>

	</h1>
</body>
</html>