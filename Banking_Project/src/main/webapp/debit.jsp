<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="jdbc.dao.classes.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="debit1.css">
<title>HOME | Debit</title>
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
        <div class="text1">Enter the amount to Debited :</div>
        <form action="Debit" method="post">
        <div class="input1"><input type="text" name="debitAmt" placeholder="Enter Amount..."></div>
        <button type="submit" >Withdraw</button>
        </form>
    </div>
</body>
</html>