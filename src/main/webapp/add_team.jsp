<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Team</title>
</head>
<body>

<form action = "add_team_action.jsp" method = "POST">
         Team Name: <input type = "text" name = "team_name">
         <br />
         Game: <input type = "text" name = "game">
         <br />
         League: <input type = "text" name = "league">
         <br />
         <input type = "submit" value = "Submit" />
      </form>

</body>
</html>