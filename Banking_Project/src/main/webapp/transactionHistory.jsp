<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="jdbc.dao.classes.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="transactionHistory.css">
<title>HOME | History</title>
</head>
<body>
		<div id="text1">Transcation Details :</div>
		<div><a href="homePageRepeat.jsp"><button id="b1">Home</button></a></div>
		<%
		ResultSet r=MainDAO.history();
		try {
			while(r.next())
			{
				if(r.getDouble(2)==0.0)
				{%>
					<div id="one" style="background-color: red;"><%out.println("Debited  :"+r.getDouble(3)); %><span id="sp1"><%out.println(r.getDate(4));out.println(r.getTime(4)); %></span></div>
				<% 
				}
				else
				{%>
					<div id="one" style="background-color: rgb(89, 255, 47);"><%out.println("Credited :"+r.getDouble(2)); %><span id="sp1"><%out.println(r.getDate(4));out.println(r.getTime(4)); %></span></div>
				<% 
				}%> 
		<% 
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		%>
		
</body>
</html>