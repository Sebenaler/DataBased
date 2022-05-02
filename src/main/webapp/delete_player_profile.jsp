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
<body><% 
			SQLRoutinesPeyton p = new SQLRoutinesPeyton();
			p.adminDeleteAccount(request.getParameter("playerID"));
			response.sendRedirect("team_list.jsp");
		%>
</body>
</html>