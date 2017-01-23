<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.java.bean.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%Login log=(Login)request.getAttribute("login"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CIS Course Registration</title>
<script type="text/javascript" src="validationstudent.js"></script>
</head>
<body>
<div id="content-outer" class="clear" style="height: 1060px;"><div id="content-wrap">
	
		<div id="content">
		
			<div id="right">			
	
	
	<h1 align="center" style="width:810px;">Course Registration Form</h1>
	<p align="center" style="font-size: 19px;width:810px;">Please fill the following details</p>
	<p align="center" style="color: red; font-size: 16px;width:810px;">* Fields are mandatory</p>
					
				<form action="stu" onsubmit="return submitted();" name="myForm" onreset=" return remove1();" id="register" style="width: 869px" method="post">
						<%if(log!=null){ %>
						 <%if("notexists".equalsIgnoreCase(log.getCourse())){%>
       <h5 style="color: red;font-size: 20px;margin-left: 575px;"> Invalid User ID</h5>
		<%} else if("no".equalsIgnoreCase(log.getUniq())){%>
       <h5 style="color: red;font-size: 20px;margin-left: 575px;"> User Already Registered</h5>
		<%} }%>
		
						<table width=100%>
						<tr>
								<td style="width: 220px;"><b>Student ID</b><span style="color: red;font-size:20px;"> * </span></td>
								<td style="width: 214px;"><input class="in" type="text" name="userid" onkeyup="return studentid1();" style="font-size: 15px;color:black;"/></td>
						
								<td><span id="studentiderror" style="color: red;margin-left: -23px;"></span></td>
							</tr>
							<tr>
								<td style="width: 220px;"><b>User Name</b><span style="color: red;font-size:20px;"> * </span></td>
								<td style="width: 214px;"><input class="in" type="text" name="username" onkeyup="return username1();" style="font-size: 15px;color:black;"/></td>
						
								<td><span id="usernameerror" style="color: red;margin-left: -23px;"></span></td>
							</tr>
							<tr>
								<td style="width: 220px;"><b>Password</b><span style="color: red;font-size:20px;"> * </span></td>
								<td style="width: 214px;"><input class="in" type="password" name="password" onkeyup="return password();" style="font-size: 15px;color:black;"/></td>
						
								<td><span id="passworderror" style="color: red;margin-left: -23px;"></span></td>
							</tr>
							
							<tr>
								<td><b>Mail ID</b></td>
								<td><input  class="in" type="text" name="mailid"  style="font-size: 15px;color:black;"/></td>
							
								<td><span id="mailiderror" style="color: red;margin-left: -23px;"></span></td>
							</tr>
							<tr>
								<td><b>Phone No</b><span style="color: red;font-size:20px;"> * </span></td>
								<td><input class="in" type="text" name="phoneno" onkeyup="return phoneno();" style="font-size: 15px;color:black;"/></td>
						
								<td><span id="phoneerror" style="color: red;margin-left: -23px;"></span></td>
							</tr>
							
							
							</table><input  type="submit" name="action" value="Register">
						
					</form>
</body>
</html>