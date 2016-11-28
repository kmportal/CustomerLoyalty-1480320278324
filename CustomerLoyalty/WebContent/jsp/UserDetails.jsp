<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <bean:define id="UserRegistrationFormBean" name="UserRegistrationFormBean"  type="com.ibm.cl.forms.UserRegistrationFormBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
tr,td{
padding-top: 15px;
font-family: sans-serif;

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
<table>
<tr valign="top">
 <td><label for="field1" ><strong> First Name: </strong></label></td>
<td><bean:write name="UserRegistrationFormBean" property="firstName"/></td>   
<td><label for="field1"> <strong>Last Name:</strong> </label></td>
<td><bean:write name="UserRegistrationFormBean" property="lastName"/>
</tr>
<tr>
 <td><label for="field1"><strong>Mobile Number:</strong></label></td>
<td><bean:write name="UserRegistrationFormBean" property="mobileNumber"/></td>  
 <td><label for="field1"><strong>Email ID:</strong></label></td>
 <td><bean:write name="UserRegistrationFormBean" property="email"/></td>  
</tr>
<tr>
<td><label for="field1"><strong>Card Number:</strong></label></td>
<td><bean:write name="UserRegistrationFormBean" property="cardNumber"/></td>  
<td><label for="field1"><strong>Points Rewarded:</strong></label></td>
<td><bean:write name="UserRegistrationFormBean" property="pointsRewarded"/></td>  
</tr>
</table>
</body>
</html>