<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String cred=(String)request.getAttribute("cred"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script>
  function validateForm(){
	  removeErrorMessages();
	  var result=false;
	  var x=user1();
	  var y=pass1();
	  
	  if(x&&y)
		  {
		  result=true;
		  }
	
	  return result;
	  
  }
   function removeErrorMessages(){
	    document.getElementById("usererror").innerHTML = '';
		document.getElementById("passerror").innerHTML = '';
		return;
   }
   /* function creden(){
	   var result=true;
		  //var a = document.myForm.userid.value;
		  var a = document.forms["myForm"]["creden"].value; 
		  if("wronguser"==a){
			  document.getElementById("credenerror").innerHTML ="Invalid User Id";
		  }else if("wrongpass"==a){
			  document.getElementById("credenerror").innerHTML ="Invalid Password";
		  }
   } */
  function user1()
  {
	  
	  var result=true;
	  //var a = document.myForm.userid.value;
	  var a = document.forms["myForm"]["userid"].value; 
	 
	  if(a.trim().length==0  || a=="" ){
		
		  document.getElementById("usererror").innerHTML ="Please enter User Id";

		  result= false;  
	  }else if (isNaN(a)){  
		  document.getElementById("usererror").innerHTML="Enter Numeric value only";  
		  return false;  
		}
	  if(result)
		  {
		  document.getElementById("usererror").innerHTML = '';
		  }

	  return result;
	  
  }
  function pass1()
  {
	  //var b = document.myForm.password.value;
	   var b = document.forms["myForm"]["password"].value; 
	  var result=true;
	  
	 
	if(b.trim().length==0|| b=="" ){
 		  
		  document.getElementById("passerror").innerHTML ="Please enter Password";

		  result= false;
	  }
	  
	 if(result)
	  {
	  document.getElementById("passerror").innerHTML = '';
	  }
 
	  return result;
  }
  </script>
</head>
<body>
Please Login to enroll for Summer Courses <br> <br>
<form action="log" name="myForm" method="post" onsubmit="return validateForm();">

<%if("wronguser".equalsIgnoreCase(cred)){%>
       <h5 style="color: red;font-size: 20px;margin-left: 575px;"> Invalid User ID</h5>
		<%} else if("wrongpass".equalsIgnoreCase(cred)){%>
		<h5 style="color: red;font-size: 20px;margin-left: 575px;"> Invalid password</h5>
		<%} %>
         <table >
       
            <tr ><td><b>User ID</b></td>
            	<td><input type="text" name="userid" onkeyup="user1();" ></td>
            	<td><span id="usererror" style="color: red;font-size: 15px;height: 35px; "></span></td>
            </tr>
            <tr ><td><b>Password:</b></td>
            <td><input type="password" name="password" onkeyup="return pass1();" ></td>
            <td><span id="passerror" style="color: red;font-size: 15px;"></span></td>
            </tr>
            <tr><td ><a href="<%=request.getContextPath() %>/Register.jsp"><b>Click here to Register</b></a></td>
            <td><input type="submit" name="action" value="Login"></td>
            </tr>
       
         
            </table>

</form>
</body>
</html>