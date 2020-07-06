<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/table.css'/>">

<title>Modify Course Page</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Modify Course Details: </h4>
    <form:form method="post" action="mentorModifyProgram.htm" commandName="program">
    
    	<form:hidden path="programId" />
    	<form:hidden path="courseId" />
    	<form:hidden path="mentorId" />
    	<form:hidden path="enrolledNoOfMentees" />
    	    	
    	Program Name: ${program.programName}<br>   	
    	<form:hidden path="programName" />
    	<br> 	  
    	<br> 
    	
    	Duration in Months: <br>   	
    	<form:select path="duration">
    			<form:option value="1">1</form:option>
    			<form:option value="2">2</form:option>
    			<form:option value="3">3</form:option>
    	</form:select>       	           		
    	<br> 	  
    	<br>   	
    	
    	No Of Mentees Allowed: <br>  
    	<form:select path="allowedNoOfMentees">    		
           		<form:option value="1">1</form:option>
    			<form:option value="2">2</form:option>
    			<form:option value="3">3</form:option>     
    			<form:option value="4">4</form:option>      
    	</form:select>   	
    	<br> 	  
    	<br> 
    	
    	Program Notes: <br> 
    	<form:textarea path="mentorProgramNotes" />    		   	
    	<br> 	  
    	<br> 
    	
    	Program Status: <br>   	
    	<form:select path="status">
    			<form:option value="Active">Active</form:option>
    			<form:option value="Inactive">Inactive</form:option>    			
    	</form:select>       	           		
    	<br> 	  
    	<br>      	    	         	    		
    	    	
    	<form:button>Modify Program</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>