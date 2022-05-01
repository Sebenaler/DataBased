<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlroutines.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Store Item</title>
</head>
<body>

<form action = "add_new_store_item_action.jsp" method = "POST">
         Item Number: <input type = "text" name = "item_number">
         <br />
         Item Name: <input type = "text" name = "item_name">
         <br />
         Item Price: <input type = "text" name = "item_price">
         <br />
         Item Description: <input type = "text" name = "item_desc">
         <br />
         Quantity: <input type = "text" name = "item_quantity" />
         <input type = "submit" value = "Submit" />
      </form>

</body>
</html>