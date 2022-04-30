<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
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
<h1>
	<%	
	String un = request.getParameter("Username");
	String pass = request.getParameter("Password");
	SQLRoutinesJoe j = new SQLRoutinesJoe();
	boolean result = j.loginPlayer(un, pass);
	if(result == true && (un != "" && pass != ""))
	{
		response.sendRedirect("index.jsp");
		session.setAttribute("loggedInUser", un);
	}
	else
	{
		response.sendRedirect("index.jsp?message= Error Message: Invalid Username or Password!");
	}
	%>

</h1>
</body>
</html>