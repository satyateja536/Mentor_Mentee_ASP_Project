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
<title>Mentor Intro Page</title>
</head>
<body>	 
    <div>
    <p>
    
    <br>
    <br>
    
    Description Of the Mentor Program 
    
    <br>
    <br>
    
    
    Who can participate as Mentor?
    
    <br>
    <br>
    
    
    How can a mentor be helpful?
    
    <br>
    <br>
    
    
    What is needed by Mentor?  
    
    <br>
    <br> 
    
    </p>    
    </div>
    <div>    	   	
    	<form:form method="post" action="mentorStatusChangeToActive.htm" commandName="user">
    	    		
    		<form:hidden path="username" />
    		<form:button>Active Mentor Role</form:button>    	
    	
		</form:form>   		   	 				
    </div>
</body>
</html>