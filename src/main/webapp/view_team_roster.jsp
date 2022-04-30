<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="sqlroutines.*"%> 
   <%@page import="java.io.*" %>
   <%@page import="java.sql.*" %>
   <%@page import="oracle.jdbc.*" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Team Roster</title>
</head>
<body>
<h1>
<% SQLRoutinesIan s = new SQLRoutinesIan();
String result1 = s.viewTeamRoster("THE JETS");
%>
<%=result1%>

</h1>
</body>
</html>