<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="createAccoun.css">
<title>Create a New Account</title>
</head>
<body>
	<div class="textBox">
        <div class="heading">
            <h1 align="center">Account Opening form</h1>
        </div>

        <div class="info">
            <h3 align="center">Information</h3>
        </div>

        <div class="body">
			<!--start of form-->
			
            <form action="Register"  method="post">
                <div class="details"><label  class="details">Personal Information</label></div>
                <br>
                <hr>
                <!-- NAME -->
                <div class="line1">
                    <label for="">Full Name</label><br>
                    <select name="gender" required>
                        <option value="Mr">Mr.</option>
                        <option value="Mr's.">Mr's.</option>
                        <option value="Ms.">Ms.</option>
                    </select>
                    <span style="margin-inline: 10px;"><input type="text" name="firstName"  required maxlength="20"></span>
                    <input type="text" name="lastName"  required maxlength="20">
                    <br>
                    <span class="s">
                        <span>Prefix</span>
                        <span id="s1">First Name</span>
                        <span id="s2">Last Name</span>
                    </span>
                </div>

                <div class="line2">
                    <label for="">Date of Birth</label><br>
                    <select name="month" id="" required>
                        <option value=""></option>
                        <option value="Jan">Jan</option>
                        <option value="Feb">Feb</option>
                        <option value="Mar">Mar</option>
                        <option value="Apr">Apr</option>
                        <option value="May">May</option>
                        <option value="June">June</option>
                        <option value="July">July</option>
                        <option value="Aug">Aug</option>
                        <option value="Sep">Sep</option>
                        <option value="Oct">Oct</option>
                        <option value="Nov">Nov</option>
                        <option value="Dec">Dec</option>
                    </select>
                    <span style="margin-inline: 12px;">
                        <select name="day" id="" required>
                            <option value=""></option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>
                    </span>
                    <select name="year"  required>
                        <option value=""></option>
                        <option value="2023">2023</option>
                        <option value="2022">2022</option>
                        <option value="2021">2021</option>
                        <option value="2020">2020</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                    </select>
                    <br>
                    <span>Month</span>
                    <span class="s">
                        <span id="s3">Day</span>
                        <span id="s4">Year</span>
                    </span>
                </div>

                <div class="line3">
                    <span class="s">
                        <span>Gaurdian Name</span>
                        <span id="s5">Telephone</span>
                    </span>
                    <br>
                    <input type="text" name="garName">
                    <span style="margin-inline: 10px;"><input type="tel" name="garPhno"></span>
                </div>

                <div class="line4">
                    <label for="">Email</label><br>
                    <input type="email" name="email" required>
                </div>

                <div class="line5">
                    <label for="">Address</label><br>
                    <input type="text" name="address">
                </div>

                <div class="line6">
                    <input type="text" name="city" >
                    <span style="margin-inline: 10px;"><input type="text" name="state" ></span>
                    <br>
                    <span>City</span>
                    <span id="s7">State</span>
                </div>

                <div class="line7">
                    <select name="country" >
                        <option value=""></option>
                        <option value="India">India</option>
                        <option value="America">America</option>
                    </select>
                    <br><span>Country</span>
                </div>


                <div class="details"><label  class="details">Account Information </label></div>
                <br>
                <hr>
                <div class="line8">
                    <span class="s">
                        <span>Account Number</span>
                        <span id="s6">Pin </span>
                    </span>
                    <br>
                    <input type="text" name="accountNo"  placeholder="Enter 8 digit custom A/C number" required maxlength="14">
                    <span style="margin-inline: 10px;"><input type="text" name="pin" placeholder="Enter custom 4 digit pin" required maxlength="4"></span>
                </div>
                <div class="butt">
                <input type="submit" value="Submit"></input>
                </div>
            </form>
        </div>
    </div>
	
</body>
</html>