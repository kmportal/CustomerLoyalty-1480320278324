<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


 <bean:define id="UserRegistrationFormBean" name="UserRegistrationFormBean"  type="com.ibm.cl.forms.UserRegistrationFormBean" />
 <script language="javascript">
 
function validate(){

var firstName = document.getElementById("firstName1").value;
var lastName = document.getElementById("lastName1").value;
var mobileNumber = document.getElementById("mobileNumber1").value;
var product = document.getElementById("product1").value;
var state = document.getElementById("state1").value;
var email = document.getElementById("email1").value;
if(firstName==''){
alert("First Name value cannot be blank");
return false;
}
if(lastName==''){
alert("Last Name value cannot be blank");
return false;
}
if(mobileNumber==''||email==''){
alert("Mobile Number or email value cannot be blank");
return false;
}
if(product==''){
alert("Product value cannot be blank");
return false;
}

if(firstName!='' && lastName!='' && mobileNumber!=''){
var regex = /^[a-zA-z]{2,30}/;
var regexMobile = /^[0-9]/;
  var regexEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
if(!regexEmail.test(email)){
alert("Email Id entered is not valid");
}
if(!regex.test(firstName)){
alert("First Name can only contain characters");
return false;
}
if(!regex.test(lastName)){
alert("Last Name can only contain characters");
return false;
}
if(mobileNumber.length!=10){
alert("Mobile Number cannot be greater than or less than 10 digits");
return false;
}
if(!regexMobile.test(mobileNumber)){
alert("Mobile Number can be only numeric");
return false;
}
}

return true;

}

 </script>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:form  action="/userRegistration.do?methodName=userCreation"  onsubmit="return validate()">
<head>
<style type="text/css" >
tr,td{
vertical-align:middle;
margin-top:5px;
padding-top: x5px;
padding-right: 5px;
padding-bottom :15px;
font-family: sans-serif;

}

input[type=text] {
	border-radius: 4px;
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.2s;
    transition: 0.5s;
    outline: none;
}

input[type=text]:focus {
    border: 3px solid #555;
}

input[type=submit] {
	
	
  display: inline-block;
  border-radius: 4px;
  background-color: #f44336;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 18px;
  padding: 8px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  text-transform:uppercase;
}

input[type=submit]:HOVER {

  display: inline-block;
  border-radius: 4px;
  background-color: red;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 18px;
  padding: 8px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  -webkit-box-shadow: 0px 0px 5px rgba(0,0,0, .75);
  -moz-box-shadow: 0px 0px 5px rgba(0,0,0, .75);
   box-shadow: 0px 0px 5px rgba(0,0,0, .75);
  
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#F0FFF0">
<table>
<tr valign="top">

 <td><label for="field1" ><strong id="firstName"  > First Name: </strong></label></td>
<td><html:text  styleId="firstName1" name="UserRegistrationFormBean" property="firstName"/></td>   

<td><label for="field1" id="lastName"> <strong>Last Name:</strong> </label></td>
<td><html:text styleId="lastName1" name="UserRegistrationFormBean" property="lastName"></html:text>
</tr>
<tr>
 <td><label for="field1" id="mobileNumber"><strong>Mobile Number:</strong></label></td>
<td><html:text maxlength="10" styleId="mobileNumber1" name="UserRegistrationFormBean" property="mobileNumber"/></td>  
 <td><label for="field1" id="product"><strong>Product:</strong></label></td>
 <td><html:text styleId="product1" name="UserRegistrationFormBean" property="product"/></td>  
</tr>
<tr>
<td><label for="field1" id="state"><strong>State:</strong></label></td>
<td><html:text styleId="state1" name="UserRegistrationFormBean" property="state"/></td>  
<td><label for="field1" id="email"><strong>Email ID:</strong></label></td>
<td><html:text styleId="email1" name="UserRegistrationFormBean" property="email"/></td>  
</tr>
<tr>
<td>
<html:submit>Submit</html:submit>
</td>
</tr>
</table>
</body>
</html:form>
</html>