<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<%@page import="sqlroutines.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Match Result</title>
</head>
<body>
		<%
		//I JUST NEED TO GET THE ID TO PASS HERE
		String id = request.getParameter("match_id");
		String score = request.getParameter("score");
		String date = request.getParameter("date");
		String link = request.getParameter("link");
		String game = request.getParameter("game");
		String enemy = request.getParameter("enemy");
		String name = request.getParameter("name");
				
		
			SQLRoutinesPeyton p = new SQLRoutinesPeyton();
			p.AdminUpdateMatchResult(id, score, date, link, game, enemy, name);
			response.sendRedirect("view_team_schedule.jsp");
		%>
</body>
</html>