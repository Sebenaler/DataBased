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
<% SQLRoutinesIan s = new SQLRoutinesIan();
ResultSet result = s.viewTeams();
%>
<%while(result.next()){%>
	<a href="/DataBased/view_team_roster.jsp?team_name=<%=result.getString(1) %>"> 
	<%=result.getString(1)+ " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4)%>
	</a><br>
	<% }%>

</body>
</html>