<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<%@page import="sqlroutines.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		//I JUST NEED TO GET THE ID TO PASS HERE AS WELL AS CHECK IF LOGGED IN PERSON ID = ID HERE

		String email = (String)session.getAttribute("loggedInUser");
		System.out.println(email);
		String pass1 = request.getParameter("pass");
		String desc = request.getParameter("desc");
		String IGN = request.getParameter("ign");
			SQLRoutinesJoe j = new SQLRoutinesJoe();
			j.editProfile(email,pass1,desc,IGN );
			response.sendRedirect("index.jsp");
		
		%>
</body>
</html>