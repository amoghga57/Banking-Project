<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="index.css">
<title>Log In</title>
</head>
<body>
	<div class="heading">
        <div id="company">Company</div>
        <div id="place">Place</div>
        <div id="address">Address</div>
        <div id="AboutUs">Abou Us</div>
    </div>
    <!-- ----------------------------------------- -->
    <form action="Validation" method="get">
    <div class="frame">
        <div class="login">Log In</div>

        <div class="position" id="name">
            <label for="username"></label>
            <input class="text" type="text" name="email"  placeholder="Enter Email ID  " autocomplete="off" required >
        </div>
    <!-- ----------------------------------------- -->
        <div class="position" id="password">
            <label for="password"></label>
            <input class="text" type="password" name="pin"  placeholder="Enter 4 digit password" autocomplete="off" required maxlength="4" required>
        </div>
    <!-- ----------------------------------------- -->

    <!-- ----------------------------------------- -->
        <div class="sign" >
            <div>New User ? <a href="createAccount.jsp">Sign in</a></div>
        </div>
		
    <!-- ----------------------------------------- -->
        <div class="confirmBox">
            <input type="checkbox" required>
            <label for="check">Valid Information</label>
        </div>

    <!-- ----------------------------------------- -->
        <div class="position" id="submit">
            <button class="loginbutton">
                <div>Log In</div>
            </button>
        </div>
    </div>
    </form>
</body>
</html>