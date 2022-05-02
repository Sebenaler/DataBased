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
	System.out.println(result + "LOGIN USER");
	boolean result2 = j.loginAdmin(un,pass);
	request.getSession().setAttribute("email",un);
	System.out.println(session.getAttribute("email"));
	System.out.println(result2+ "DHSFJDHSJFHDSF");
	%>
	<% if(result == true)
	{
		session.setAttribute("loggedInUser", un);
		response.sendRedirect("index.jsp");

	}
	else if(result2 == true)
	{
		session.setAttribute("loggedInAdmin", un);
		response.sendRedirect("index.jsp");

	}
	else
	{
		response.sendRedirect("login.jsp?message= Error Message: Invalid Username or Password!");
	}%>
</body>
</html>