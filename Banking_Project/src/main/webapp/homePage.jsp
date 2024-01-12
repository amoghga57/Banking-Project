<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jdbc.dao.classes.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="homePage.css">
<title>HOME | Account</title>
</head>
<body id="body">
	<div class="panel">
    <h3>
        Account Number :<span  style="color:red">
    <%
        MainDAO.settingThePinConstant(request.getParameter("pin"));
        String accNo = MainDAO.accNo();
        out.print(accNo);
    %> 
    </span>
    </h3>
    <h3>Username :<span  style="color:red">
    <%
        String username = MainDAO.username();
        out.print(username);
    %> 
    </span></h3>
    <h3>E-mail ID :
    <span  style="color:red">
    <%
        String email= MainDAO.email();
        out.print(email);
    %>
    </span></h3>
    <div class="logo">
        <button onclick="disp()" ><%out.print(MainDAO.firstLastName()); %></button>
    </div>
</div>
<div class="head1">
    <div class="box1">
        <a href="credit.jsp"><button>Credit</button> </a>
    </div>
    <div class="box2">
        <a href="debit.jsp"><button>Debit</button></a>
    </div>
    <div class="box3">
        <a href="balance.jsp"><button>Balance</button></a>
	</div>
</div>

<div class="head2" id="disp" >
    <div class="b1">
        <a href=""><button>Edit Account</button></a>
    </div>
    <div class="b2">
        <button onclick="deletAcc()">Delete Account</button>
    </div>
    <div class="b3">
        <a href="transactionHistory.jsp"><button>Transaction History</button></a>
    </div>
    <div class="b4">
        <a href="index.jsp"><button>Log Out</button></a>
    </div>
</div>
<div class="head3" id="deleteBox">
    <div class="confirmBox">
        <span style="color: rgb(236, 210, 210);">Are you sure  ?</span>
        <span><a href=""><button id="cross">x</button></a></span>
        <form action="DeleteAccount" method="get">
        <br>
        <span><a href="index.jsp"><button id="sure" >Sure</button></a></span>
        <br>
        <h3>I , hereby delete this account on my own</h3>
    	</form>
    </div>
</div>
	<script src="homePage.js"></script>
</body>	
</html>