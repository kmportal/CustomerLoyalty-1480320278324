<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
h1 {
	text-transform:capitalize;
	font-style: normal;
	font-family: fantasy;
	font-size: xx-large;
	 font-stretch:wider;
	text-align: center;
	color: navy;
}

body{
background-image: url("common/images/background.jpg");
background-repeat: no-repeat;
background-position: ;
-webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        padding-bottom: 100px;
        margin-left: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE><tiles:getAsString name="title" /></TITLE>
</head>
<body>
<h1>Customer Loyalty System</h1>

<div class="wrapper">
  		<tiles:insert attribute="header" />
  
	  
	<div class="content clearfix">
	   	<div class="left-side clearfix" align="justify" style="border-top:3px solid #cccccc; margin-left: 5px">
	   	
			<tiles:insert attribute="menu" />
			
		</div>
	   	<div class="right-side clearfix"  >
			
			<tiles:insert attribute="body" />
		</div>
	</div>
		
		
	<div class="footer">
		<tiles:insert attribute="footer" />
	</div>
</div>
</body>
</html>