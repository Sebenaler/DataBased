<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Team</title>
</head>
<body>
	<% SQLRoutinesBen s = new SQLRoutinesBen();
       s.removeTeam(request.getParameter("team_name"));
       //request.setAttribute("team_name", request.getParameter("team_name"));
       //response.sendRedirect("view_team_roster.jsp");
    %>
    
    <a href="./team_list.jsp"> 
	<button type="button">Confirm Remove</button>
	</a><br>
    
</body>
</html>