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

<form action = "add_match_to_schedule_action.jsp" method = "POST">
         Match ID: <input type = "text" name = "match_id">
         <br />
         Match Date: <input type = "text" name = "match_date">
         <br />
         Media Link: <input type = "text" name = "media_link">
         <br />
         Game: <input type = "text" name = "game">
         <br />
         Opponent: <input type = "text" name = "opponent">
         <br />
         <input type = "hidden" name = "team_name" value = "<%=request.getParameter("team_name")%>">
         <input type = "submit" value = "Submit" />
      </form>

</body>
</html>