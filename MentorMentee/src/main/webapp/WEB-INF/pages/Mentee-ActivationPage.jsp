<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/table.css'/>">
<title>Mentee Activation Page</title>
</head>
<body>	 
    <div>
    <p>
    
    <br>
    <br>
    Description Of the Mentee Program 
    
    <br>
    <br>
    
    Who can participate as Mentee?
    
    <br>
    <br>
    
    How can a mentee get help?
    
    <br>
    <br>
    
    What is needed by Mentee?   
    
    <br>
    <br>
    
    </p>    
    </div>
    <div>
    	<form:form method="post" action="menteeStatusChangeToActive.htm" commandName="user">
    	    		
    		<form:hidden path="username" />
    		<form:button>Activate Mentee Role</form:button>    		
    	
		</form:form>
    	  	
    </div>
</body>
</html>