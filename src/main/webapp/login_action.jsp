<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@page import="sqlroutines.*"%> 
   <%@page import="java.io.*" %>
   <%@page import="java.sql.*" %>
   <%@page import="oracle.jdbc.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
	String un = request.getParameter("uname");
	String pass = request.getParameter("psw");
	SQLRoutinesJoe j = new SQLRoutinesJoe();
	boolean result = j.loginPlayer(un, pass);
	%>
	<% if(result == true )
	{
		response.sendRedirect("team_list.jsp");
		session.setAttribute("loggedInUser", un);
	}
	else
	{
		response.sendRedirect("login.jsp?message= Error Message: Invalid Username or Password!");
	}%>
</body>
</html>