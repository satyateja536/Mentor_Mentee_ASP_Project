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

<title>Employee Validation Page</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Get Employee Details: </h4>
    <form:form method="post" action="getEmployeeDetails.htm" commandName="employee">
    
    	    	
    	Enter Employee Id: <br>   	
    	<form:input path="employeeId" />
    	<br> 	  
    	<br> 	    	
    	    	
    	<form:button>Get Employee</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>