<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="sqlroutines.*"%> 
   <%@page import="java.io.*" %>
   <%@page import="java.sql.*" %>
   <%@page import="oracle.jdbc.*" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<% SQLRoutinesIan s = new SQLRoutinesIan();
Class.forName("oracle.jdbc.OracleDriver");

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclerh7srv.ad.csbsju.edu:1521/" +
        "csci.cscioraclerh7srv.ad.csbsju.edu","TEAM01", "team01");
String queryString = "select u.first, u.last from player_table u, plays_on p where u.player_id = p.player_id and p.team_name = '" + "THE JETS" + "'";
Statement stmt;
String result1 = "";
stmt = con.createStatement();
ResultSet result = stmt.executeQuery(queryString);
while (result.next()){    
	result1 = result.getString(1);
  System.out.println(result.getString(1));
}
%>
<%=result1%>

</h1>
</body>
</html>