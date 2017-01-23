<%@page import="com.java.bean.CourseDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.java.bean.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
Login l = null;
l = (Login)request.getAttribute("details");
CourseDetails cd=null;
cd=(CourseDetails)request.getAttribute("coursedetails");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrollment Form</title>
</head>
<body>
<h1><%="Welcome" %></h1>
<h2><%=l.getuName() %></h2>
<form action="stu" method="post">

Please enroll for the courses<br>
<table>
<%if(cd!=null){
if("yes".equalsIgnoreCase(cd.getCheck())){%>
<tr>
<td>You have already enrolled to <%=cd.getCourse_name() %></td></tr><%}else{ %>
<tr>
<td>You have successfully enrolled to <%=cd.getCourse_name() %></td></tr>
<tr>
<td>Only <%=cd.getCourse_count() %> <%=cd.getCourse_name()%> seats available</td></tr>
<%} }%>
<tr><td><input type='hidden' id='userid' value="<%=l.getuId()%>" name="useriden"></td></tr>
<tr><td><input type='hidden' id='username' value="<%=l.getuName()%>" name="username"></td></tr>
<tr>
		
	<td><select class="in" name="subjects"  style="font-size: 15px;color:black;"><option value="0">Select</option>
										<%
						for(String s:l.getSubjects())
						{
					%>
						<option value="<%=s%>"><%=s%></option>
					<%
						}
					%></select></td>
							
								<td><span id="enrollerror" style="color: red;margin-left: -20px;"></span></td>
							</tr>
</table>


<input type="submit" name="action" value="Enroll"><br>
<a style="font-size:15px;" href="<%=request.getContextPath() %>/Logout.jsp"><b>Click here to Logout</b></a>
</form>
</body>
</html>