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
 <form action="update_match_action.jsp" method="post">
  <div class="container">
     <input type = "hidden" name = "match_id" value = "<%=request.getParameter("match_id")%>">
        <label for="score"><b>Score</b></label>
    <input type="text" placeholder="Enter Score:" name="score">
    

    <button type="submit">Submit</button>
  </div>

</body>
</html>