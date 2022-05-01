<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Player To Team</title>
</head>
<body>

<form action = "add_player_to_team_action.jsp" method = "POST">
         Player ID: <input type = "text" name = "player_id">
         <br />
         <input type = "hidden" name = "team_name" value = "<%=request.getParameter("team_name")%>">
         <input type = "submit" value = "Submit" />
      </form>

</body>
</html>