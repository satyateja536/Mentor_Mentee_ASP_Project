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

<title>New Course Page</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Enter Course Details: </h4>
    <form:form method="post" action="newCourse.htm" commandName="course">
    
    	    	
    	Enter Course Name: <br>   	
    	<form:input path="courseName" />
    	<br> 	  
    	<br> 
    	
    	Course Level: <br>   	
    	<form:select path="courseLevel">    		
           		<form:option value="Basic">Basic</form:option>
           		<form:option value="Intermediate">Intermediate</form:option>
           		<form:option value="Advanced">Advanced</form:option>            
    	</form:select>
    	<br> 	  
    	<br>   	
    	
    	Course Group: <br> 
    	<form:select path="courseGroup">
    		<c:forEach items="${groupList}" var="group">
               			<form:option value="${group.groupName}">${group.groupName}</form:option>
            </c:forEach>
    	</form:select>    	
    	<br> 	  
    	<br>     	
    	         	
    	Course Status: <br>  
    	<form:select path="courseStatus">    		
           		<form:option value="Active">Active</form:option>
           		<form:option value="Inactive">Inactive</form:option>            
    	</form:select>   	
    	<br> 	  
    	<br> 	
    	    	
    	<form:button>Add Course</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>