<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Match To Schedule</title>
</head>
<body>

	<% SQLRoutinesBen s = new SQLRoutinesBen();
s.addMatch(request.getParameter("match_id"), request.getParameter("match_date"), request.getParameter("media_link"), request.getParameter("game"), request.getParameter("opponent"), request.getParameter("team_name"));
//request.setAttribute("team_name", request.getParameter("team_name"));
//response.sendRedirect("view_team_roster.jsp");
%>

<a href="./view_team_schedule.jsp?team_name=<%=request.getParameter("team_name")%>"> 
	<button type="button">Confirm Add</button>
	</a><br>

</body>
</html>