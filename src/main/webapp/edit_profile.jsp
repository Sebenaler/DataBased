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
 <form action="edit_profile_action.jsp" method="post" >
<h1>Edit Profile</h1>
  <div class="container">

        <label for="pass"><b>Password</b></label>
    <input type="password" placeholder="Enter New Password" name="pass" required>
    
        <label for="desc"><b>Description</b></label>
    <input type="text" placeholder="Enter New Description" name="desc" required>
    
        <label for="ign"><b>In Game Name</b></label>
    <input type="text" placeholder="Enter New IGN" name="ign" required>

    <button type="submit">Submit</button>
  </div>
      <a href="./index.jsp"> 
	<button type="button">Back Home</button>
	</a>
</body>
</html>