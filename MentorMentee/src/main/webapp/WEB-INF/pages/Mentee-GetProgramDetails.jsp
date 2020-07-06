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

<title>Get Program Details</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Get Program Details: </h4>
    <form:form method="post" action="menteeGetProgram.htm" commandName="program">
    
    	    	
    	Select Program: <br> 
    	<form:select path="programName">
    		<c:forEach items="${programNames}" var="prgmName">
    			<form:option value="${prgmName}">${prgmName}</form:option>    			
        	</c:forEach>
    	</form:select>     	
    	<br> 	  
    	<br> 	    	
    	    	
    	<form:button>Get Program</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>