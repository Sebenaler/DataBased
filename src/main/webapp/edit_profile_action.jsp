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
		//I JUST NEED TO GET THE ID TO PASS HERE
		String id = "05";
		String pass1 = request.getParameter("pass");
		String desc = request.getParameter("desc");
		String IGN = request.getParameter("ign");
			SQLRoutinesJoe j = new SQLRoutinesJoe();
			j.editProfile(id,pass1,desc,IGN );
			response.sendRedirect("team_list.jsp");
		%>
</body>
</html>