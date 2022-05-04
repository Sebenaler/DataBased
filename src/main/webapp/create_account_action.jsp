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
	String id = request.getParameter("id");
	String lname = request.getParameter("fname");
	String fname = request.getParameter("lname");
	String email = request.getParameter("email");
	String pass1 = request.getParameter("psw1");
	String pass2 = request.getParameter("psw2");
	String year = request.getParameter("year");
	String desc = request.getParameter("desc");
	String ssm = request.getParameter("ssm");
	String IGN = request.getParameter("IGN");
	SQLRoutinesJoe j = new SQLRoutinesJoe();
	boolean result = j.createAccount(id,lname,fname,email,pass1,pass2,year,desc,ssm,IGN);
	%>
	<% if(result==true)
	{
		response.sendRedirect("index.jsp");
		//session.setAttribute("loggedInUser", id);
	}
	else
	{
		response.sendRedirect("create_account.jsp?message= Error Message: Invalid Information!");
	}%>
</body>
</html>