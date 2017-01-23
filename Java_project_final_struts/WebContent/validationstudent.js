function remove1()
{
	document.getElementById("studentiderror").innerHTML = '';
	document.getElementById("mailiderror").innerHTML = '';
	document.getElementById("phoneerror").innerHTML = '';
	document.getElementById("usernameerror").innerHTML = '';
	document.getElementById("passworderror").innerHTML = '';
	

return;

}
function removeErrorMessage() {
	document.getElementById("studentiderror").innerHTML = '';
	document.getElementById("mailiderror").innerHTML = '';
	document.getElementById("phoneerror").innerHTML = '';
	document.getElementById("usernameerror").innerHTML = '';
	document.getElementById("passworderror").innerHTML = '';
	return;
}
function submitted(){
	
	var res=true;

	res=validateForm();
	if(res==true)
	{
	r=confirm("Do you want to submit ? ");
	if(r==true)
		{
		res=true;
		}
	else
		{
		res=false;
		}
	}
	return res;
}
function validateForm()

{
	var res=false;
	removeErrorMessage();
	var r1=username1();
	 var r2=studentid1();
	 var r3=password();
	 var r4=phoneno();
	if(r1==true&&r2==true&&r3==true&&r4==true)
		{
		res=true;
		}
	
		return res;
}
function studentid1(){
var result=true;
	
	var x = document.forms["myForm"]["userid"].value;
	if (x.trim().length==0|| x=="" )
	  {

		document.getElementById("studentiderror").innerHTML ="Please enter your User ID";

	  result= false;
	  }else if (isNaN(x)){  
		  document.getElementById("studentiderror").innerHTML="Enter Numeric value only";  
		  return false;  
		}
	else if(x.length!=9)
	{
	
		document.getElementById("studentiderror").innerHTML ="User ID should be 9 digit number";
	  result= false;
	}
	else if (x.match(' '))
	{ 
	document.getElementById("studentiderror").innerHTML ="User ID should not contain spaces";
	  result= false;
	}
	 else if(!x.match("^[a-zA-Z0-9.]*$"))
	 {
	 document.getElementById("studentiderror").innerHTML ="User ID should not contain special characters";
	  result= false;
	 }
	else if(true)
	{
	if(result){
		
		document.getElementById("studentiderror").innerHTML ="";
	}
	
	}
	
	return result;
}
function phoneno(){
	var result=true;
	var x = document.forms["myForm"]["phoneno"].value;
	if (x.trim().length==0|| x=="" )
	  {

		document.getElementById("phoneerror").innerHTML ="Please enter Phone No";

	  result= false;
	  }
	else if(x.length!=10)
	{
	
		document.getElementById("phoneerror").innerHTML ="Phone No should be a 10 digit number";
	  result= false;
	}else if (isNaN(x)){  
		  document.getElementById("phoneerror").innerHTML="Enter Numeric value only";  
		  return false;  
		}
	else if (x.match(' '))
	{ 
	document.getElementById("phoneerror").innerHTML ="Phone No should not contain spaces";
	  result= false;
	}else if(!x.match("^[a-zA-Z0-9.]*$"))
	 {
		 document.getElementById("phoneerror").innerHTML ="Phone No should not contain special characters";
		  result= false;
		 }
		else if(true)
		{
		if(result){
			
			document.getElementById("phoneerror").innerHTML ="";
		}
		}
		
	return result;
}
function password(){
	var result=true;
	var x = document.forms["myForm"]["password"].value;
	if (x.trim().length==0|| x=="" )
	  {

		document.getElementById("passworderror").innerHTML ="Please enter Password";

	  result= false;
	  }
	else if(x.length>20)
	{
	
		document.getElementById("passworderror").innerHTML ="Password field should contain less than 20 characters";
	  result= false;
	}
	else if (x.match(' '))
	{ 
	document.getElementById("passworderror").innerHTML ="Password field should not contain spaces";
	  result= false;
	}else if(true)
		{
		if(result){
			
			document.getElementById("passworderror").innerHTML ="";
		}
		}
	return result;
}
function username1()
{

var result=true;

	var x = document.forms["myForm"]["username"].value;
	if (x.trim().length==0|| x=="" )
	  {

		document.getElementById("usernameerror").innerHTML ="Please enter User name";

	  result= false;
	  }
	else if(x.length>20)
	{
	
		document.getElementById("usernameerror").innerHTML ="User name field should contain less than 20 characters";
	  result= false;
	}
	else if (x.match(' '))
	{ 
	document.getElementById("usernameerror").innerHTML ="User name field should not contain spaces";
	  result= false;
	}
	 else if(!x.match("^[a-zA-Z0-9.]*$"))
	 {
	 document.getElementById("usernameerror").innerHTML ="User name field should not contain special characters";
	  result= false;
	 }
	else if(true)
	{
	var a=x.match(/\d+/g);
	 if(a!=null)
	{
	
	document.getElementById("usernameerror").innerHTML ="User name field should not contain numerics";
	  result= false;
	}if(result){
		
		document.getElementById("usernameerror").innerHTML ="";
	}
	
	}
	
	return result;
}