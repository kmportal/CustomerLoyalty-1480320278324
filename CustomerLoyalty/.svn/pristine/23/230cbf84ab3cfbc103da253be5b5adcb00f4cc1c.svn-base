<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<style type="text/css">

tr,td{
vertical-align:middle;
margin-top:5px;
padding-top: x5px;
padding-right: 5px;
padding-bottom :15px;
font-family: sans-serif;

}
a:link, a:visited {
    background-color: #f44336;
    color: white;
    text-transform:uppercase;
    padding: 14px 25px;
    text-align: center;
    text-decoration: underline;
    display: inline-block;
    margin-top: 10px;
  
    
}

a:hover, a:active {
    background-color: red;
    border-radius: 4px;
    -webkit-box-shadow: 0px 0px 5px rgba(0,0,0, .75);
  -moz-box-shadow: 0px 0px 5px rgba(0,0,0, .75);
   box-shadow: 0px 0px 5px rgba(0,0,0, .75);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campaign Page</title>
</head>
<body bgcolor="#F0FFF0">

<logic:notEmpty name="CAMPAIGN_DETAILS">
			<bean:define id="campaignDetailsList" name="CAMPAIGN_DETAILS" type="java.util.ArrayList" scope="request"  />
		</logic:notEmpty>
		<logic:empty name="campaignDetailsList" >
		<table width="100%" border="0" cellspacing="0" cellpadding="2" class="form1">
					
				<TR>	
					<TD align="left" valign="top" class="labelValue"><b><bean:message key="campaign.not.found" /></b></TD>
				</TR>
				</table>
			
		</logic:empty>
		
		<logic:notEmpty name="campaignDetailsList" >
			 <logic:iterate name="campaignDetailsList" type="com.ibm.cl.dto.CampaignDetailsDto" id="details">
			  
			  <table width="100%" border="0" cellspacing="0" cellpadding="2" class="form1">
					
				<TR>	
					<TD align="left" valign="top" class="labelValue"><b><bean:write name="details" property="message" /> from <bean:write name="details" property="validFrom" /> To <bean:write name="details" property="validTo" /></b></TD>
				</TR>
				</table>
			  </logic:iterate>
				</logic:notEmpty>

</body>