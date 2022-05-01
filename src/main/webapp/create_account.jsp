<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@page import="java.io.*" %>
   <%@page import="java.sql.*" %>
   <%@page import="oracle.jdbc.*" %>
   	<%@page import="sqlroutines.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Account</title>
</head>
<body>
 <form action="create_account_action.jsp" method="post">
  <div class="container">
    <label for="id"><b>User ID</b></label>
    <input type="text" placeholder="Enter ID" name="id" required>
    
        <label for="fname"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="fname" required>
    
        <label for="lname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="lname" required>
    
        <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
    
        <label for="psw1"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw1" required>
    
        <label for="psw2"><b>Password2</b></label>
    <input type="password" placeholder="Enter Password Again" name="psw2" required>
    
        <label for="year"><b>Player Year</b></label>
    <input type="text" placeholder="Enter Year" name="year" required>
    
        <label for="desc"><b>Description</b></label>
    <input type="text" placeholder="Enter Description" name="desc" required>

    <label for="ssm"><b>Social Media</b></label>
    <input type="text" placeholder="Enter Social Media" name="ssm" required>
    
        <label for="IGN"><b>In Game Name</b></label>
    <input type="text" placeholder="Enter IGN" name="IGN" required>

    <button type="submit">Submit</button>
  </div>

</body>
</html>