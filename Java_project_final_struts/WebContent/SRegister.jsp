<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page errorPage="error.jsp" %>
    <%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<h1 align="center" style="width:810px;">Course Registration Form</h1>
	<p align="center" style="font-size: 19px;width:810px;">Please fill the following details</p>
	<font color="red"><s:property value="errorMsg" /></font><br/>
	<s:form action="register1" >
	<table>
						<tr>
								<td ><b>Student ID</b></td>
								<td ><s:textfield name="userid" /></td>
						
							</tr>
							<tr>
								<td ><b>User Name</b></td>
								<td ><s:textfield name="username"/></td>
						
							</tr>
							<tr>
								<td><b>Password</b></td>
								<td ><s:password name="password"/></td>
						
							</tr>
							
							<tr>
								<td><b>Mail ID</b></td>
								<td><s:textfield name="mailid"/></td>
							
							</tr>
							<tr>
								<td><b>Phone No</b></td>
								<td><s:textfield name="phoneno"/></td>
						
							</tr>
							<tr><td><s:submit value="Register"/></td>
							</tr>
							
							</table>
							
						
</s:form>

</body>
</html>