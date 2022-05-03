<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<%@page import="sqlroutines.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Match</title>
</head>
<body>
 <form action="test1.jsp" method="post">
  <div class="container">
     
     <h3>Enter what you want to search for (if you want to search all players then leave everything blank and click submit)</h3>
        <label for="ID"><b>PlayerID</b></label>
    <input type="text" placeholder="Enter Player ID:" name="ID">
    	<label for="last"><b>last</b></label>
    <input type="text" placeholder="Enter Last Name:" name="last">
    	<label for="first"><b>first</b></label>
    <input type="text" placeholder="Enter First Name:" name="first">
    	<label for="email"><b>email</b></label>
    <input type="text" placeholder="Enter email:" name="email">
    	<label for="year"><b>year</b></label>
    <input type="text" placeholder="Enter student year:" name="year">
    	<label for="IGN"><b>inGameName</b></label>
    <input type="text" placeholder="Enter GamerTag:" name="IGN">
    

    <button type="submit">Submit</button>
    <a href="./team_list.jsp"> 
	<button type="button">Back to All Teams</button>
	</a>
    
  </div>

</body>
</html>