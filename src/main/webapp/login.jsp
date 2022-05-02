<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@page import="sqlroutines.*"%> 
   <%@page import="java.io.*" %>
   <%@page import="java.sql.*" %>
   <%@page import="oracle.jdbc.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>
 <form action="login_action.jsp" method="post">
  <div class="container">
    <label for="uname"><b>Email</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <button type="submit">Login</button>
  </div>

</form> 
	<%	/*
	String un = request.getParameter("uname");
	String pass = request.getParameter("psw");
	String user = "LJONES001@csbsju.edu";
	String password = "1234";
	SQLRoutinesJoe j = new SQLRoutinesJoe();
	boolean result = j.loginPlayer(un, pass);
	*/%>
	<%/* if(result = true && (user != "" && password != ""))
	{
		//response.sendRedirect("index.jsp");
		session.setAttribute("loggedInUser", user);
	}
	else
	{
		response.sendRedirect("index.jsp?message= Error Message: Invalid Username or Password!");
	}*/%>
	

</h1>
</body>
</html>