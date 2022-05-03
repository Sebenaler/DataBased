<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>
<%@page import="sqlroutines.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
</head>
<body>
		<a href="./view_store.jsp"> 
	<button type="button">View Store</button>
	</a>
	
			<a href="./edit_profile.jsp"> 
	<button type="button">Edit Profile</button>
	</a>
	
			<a href="./team_list.jsp"> 
	<button type="button">View Teams</button>
	</a>
	
	<a href="./search_player.jsp"> 
	<button type="button">Search for Player</button>
	</a>
	
	<div style="float:right">
	<form align="right" name="form1" method="post" action="log_out.jsp">
	  <label class="logoutLblPos">
	  <input name="submit2" type="submit" id="submit2" value="log out">
	  </label>
	</form>
	</div>

	
</body>
</html>