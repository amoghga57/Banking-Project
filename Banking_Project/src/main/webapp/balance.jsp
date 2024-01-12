<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="jdbc.dao.classes.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="balance.css">
<title>HOME | Balance</title>
</head>
<body>
	<div class="panel">
		<h3>Account Number :
		<span  style="color:red"><%
			String accNo = MainDAO.resaccNo;
			out.print(accNo);
		%>
		</span></h3>
		<h3>USERNAME : <span  style="color:red"><%
			String username = MainDAO.resusername;
			out.print(username);
		%>
		</span></h3>
		<h3>E-mail : <span  style="color:red"><%
			String email= MainDAO.resemail;
			out.print(email);
		%>
		</span></h3>
	</div>
    <div class="head1">
        <div class="text1">Balance</div>
        <div class="text2">Remaining amount is :</div>
        <div style="color:">
        <h1 >
        	<%	
        	double d=MainDAO.remBalance();
        	out.print(d);
        	%>
        </h1>
        </div>
        <a href="homePageRepeat.jsp"><button>HOME</button> </a>
    </div>
</body>
</html>