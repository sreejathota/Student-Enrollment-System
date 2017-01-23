<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrollment Form</title>
</head>
<body>
<h2> <%="Hi" %></h2>
<h2><s:property value="userName" /></h2>
<b>Enrolled courses:</b>
 <s:iterator value="enrolledsub">
	 <s:property></s:property><br/>
</s:iterator>
<br/><br/> 
<%-- <s:radio name="radio" value="enrolledsub"/> --%>
<%-- <s:property value="enrolledsub" /> --%>
<h3> <%="Enroll for the courses" %></h3>
<s:property value="Msg1" /><br/>
<s:property value="Msg2" /><br/>

<s:form action="enroll">
<table>
<tr><td><s:hidden name="hiddenValue1" value="%{uId}" /></td></tr>
<tr><td><s:hidden name="hiddenValue2" value="%{userName}"/></td></tr>

<tr><td><s:select name="subjects" list="sub" headerKey="-1" headerValue="Select Value"/></td></tr>

</table>

		<s:submit method="enroll" value="Enroll" />
        <s:submit method="drop" value="Drop Course" />
       
<a href="<s:url action="logout"/>">Click here to Logout</a>
</s:form>
</body>
</html>