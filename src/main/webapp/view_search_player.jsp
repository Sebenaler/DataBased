<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Searched For Player</title>
</head>
<body>
<h1>Players: </h1>
	<h3>
	<% SQLRoutinesPeyton p = new SQLRoutinesPeyton();
	String id = request.getParameter("ID");
	String last = request.getParameter("last");
	String first = request.getParameter("first");
	String year = request.getParameter("year");
	String IGN = request.getParameter("IGN");
	
	ResultSet result = p.AdminSearchProfiles(id,last,first,year,IGN);
%>
		<% while (result.next()){    %>
    	<%=result.getString(3) + " " + result.getString(2)%>
    	<%if(session.getAttribute("loggedInAdmin") != null){%>
      	<a href="./remove_player_from_team.jsp?player_id=<%=result.getString(1)%>"> 
	<button type="button">Remove Player</button>
	</a><% }%>
		<a href="./view_player_profile.jsp?player_id=<%=result.getString(1) %>"> 
	<button type="button">View Profile</button>
	</a><br>
    <%}%>


	<a href="./team_list.jsp"> 
	<button type="button">Back to All Teams</button>
	</a><br>
</body>
</html>