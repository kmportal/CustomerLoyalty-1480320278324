<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <bean:define id="UserRegistrationFormBean" name="UserRegistrationFormBean"  type="com.ibm.cl.forms.UserRegistrationFormBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
function validate(){
var mobileNumber = document.getElementById("mobileNumber1").value;
var cardNumber = document.getElementById("cardNumber1").value;
if(mobileNumber=='' && cardNumber==''){
alert("Both Mobile Number & Card Number values cannot be blank");
return false;
}
if(mobileNumber!=''){
var regex = /^[0-9]/;
if(!regex.test(mobileNumber)){
alert("Mobile Number can be numeric only");
return false;
}
if(mobileNumber.length!=10){
alert("Mobile Number should be a 10 digit number");
return false; 
}

}

if(cardNumber!=''){
var regexCard = /^[0-9]/;
if(!regexCard.test(cardNumber)){
alert("Card Number can be numeric only");
return false;
}
if(cardNumber.length!=18){
alert("Card Number should be a 18 digit number");
return false; 
}

}

return true;
}
</script>
<html>
<head>
<style type="text/css">
tr,td{
padding-top: 15px;
font-family: sans-serif;

}

input[type=text] {
	border-radius: 4px;
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
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
  
  
}

input[type=submit]:HOVER {
	text-transform:uppercase;
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
<title>Insert title here</title>
</head>
<body bgcolor="#F0FFF0">
<html:form action="/userSearch.do?methodName=userSearch"  onsubmit="return validate()">
<table>
<tr>
 <td><label for="field1" ><strong> Card Number: </strong></label></td>
<td><html:text maxlength="18" styleId="cardNumber1" name="UserRegistrationFormBean" property="cardNumber"/></td>
</tr>
<tr>
 <td><label for="field1" ><strong> Mobile Number: </strong></label></td>
<td><html:text styleId="mobileNumber1" maxlength="10" name="UserRegistrationFormBean" property="mobileNumber"/></td>
</tr>
<tr>
<td>

<html:submit style="vertical-align:middle">SUBMIT</html:submit>
	
</td>

</tr>
</table>
</html:form>
</body>
</html>