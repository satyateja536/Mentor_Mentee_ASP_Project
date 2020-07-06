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

<title>Get Course Details</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Get Course Details: </h4>
    <form:form method="post" action="mentorNewProgramPage.htm" commandName="course">
    
    	    	
    	Select Course: <br> 
    	<form:select path="courseName">
    		<c:forEach items="${courseNames}" var="courseName">
    			<form:option value="${courseName}">${courseName}</form:option>    			
        	</c:forEach>
    	</form:select>     	
    	<br> 	  
    	<br> 	    	
    	    	
    	<form:button>Get Course</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>