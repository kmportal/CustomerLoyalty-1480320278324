<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


 <bean:define id="UserRegistrationFormBean" name="UserRegistrationFormBean"  type="com.ibm.cl.forms.UserRegistrationFormBean" />
 <script language="javascript">
 

		function validate() {

			var mobileNumber = document.getElementById("mobileNumber1").value;
			var product = document.getElementById("product1").value;

			if (mobileNumber == '') {
				alert("Mobile Number value cannot be blank");
				return false;
			}
			if (product == '') {
				alert("Product value cannot be blank");
				return false;
			}

			if (firstName != '' && lastName != '' && mobileNumber != '') {

				var regexMobile = /^[0-9]/;

				if (mobileNumber.length != 10) {
					alert("Mobile Number cannot be greater than or less than 10 digits");
					return false;
				}
				if (!regexMobile.test(mobileNumber)) {
					alert("Mobile Number can be only numeric");
					return false;
				}
			}

			return true;

		}
	</script>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:form  action="/userRegistration.do?methodName=addProduct"  onsubmit="return validate()">
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
select{


	border-radius: 4px;
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    outline: none;
}
option{
		border-radius:4px;
		box-sizing:border-box;
		outline:none;
		

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

<tr>
 <td><label for="field1" id="mobileNumber"><strong>Mobile Number:</strong></label></td>
<td><html:text maxlength="10" styleId="mobileNumber1" name="UserRegistrationFormBean" property="mobileNumber"/></td>  
 <td><label for="field1" id="product"><strong>Product:</strong></label></td>
 <td><html:select styleId="product1" name="UserRegistrationFormBean" property="product">
  		<html:option value="-1">Select</html:option>
  		<html:optionsCollection name="productList" value="productId" label="productName"></html:optionsCollection>
  	</html:select>
 </td>  
</tr>

<tr>
<td>
<html:submit>Submit</html:submit>
</td>
</tr>
<logic:present name="message">
   <tr>
     <td colspan="2"><label><bean:write name="message"/></label></td>
   </tr>
</logic:present>
</table>
</body>
</html:form>
</html>