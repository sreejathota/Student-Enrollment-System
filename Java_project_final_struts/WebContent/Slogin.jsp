<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login </title>
</head>
<body>

<font color="red"><s:property value="errorMsg" /></font><br/>
Please Login to enroll for Summer Courses <br>
<s:form action="login" method="post">
<table>
   <tr ><td><b>User ID</b></td>
	<td><s:textfield name="name" /></td></tr>
	<tr ><td><b>Password:</b></td>
          <td><s:password name="pass" /></td></tr>
	<tr><td><a href="<s:url action="Register"/>">Click here to Register</a></td>
	<td><s:submit name="Login"/></td></tr>
	</table>
	</s:form>
</body>
</html>