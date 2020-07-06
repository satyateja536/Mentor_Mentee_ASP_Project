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
    <form:form method="post" action="modifyCourse.htm" commandName="course">
    
    	<form:hidden path="courseId" />
    	    	
    	Course Name: ${course.courseName}<br>   	
    	<form:hidden path="courseName" />
    	<br> 	  
    	<br> 
    	
    	Course Level: ${course.courseLevel} <br>   	
    	<form:hidden path="courseLevel" />       	           		
    	<br> 	  
    	<br>   	
    	
    	Course Group: ${course.courseGroup}<br> 
    	<form:hidden path="courseGroup" />    		   	
    	<br> 	  
    	<br>     	
    	         	
    	Course Status: <br>  
    	<form:select path="courseStatus">    		
           		<form:option value="Active">Active</form:option>
           		<form:option value="Inactive">Inactive</form:option>            
    	</form:select>   	
    	<br> 	  
    	<br> 	
    	    	
    	<form:button>Modify Course</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>