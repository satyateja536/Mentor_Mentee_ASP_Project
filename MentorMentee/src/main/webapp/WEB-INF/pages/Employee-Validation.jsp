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

<title>Employee Validation Page</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <form:form method="post" action="validateEmployee.htm" commandName="formInputs">
    
    	Enter Employee Id: <br>
    	<form:input path="employeeId" />
    	<br>
    	
    	Enter Employee Name: <br>   	
    	<form:input path="employeeName" />
    	<br>
    	<br>
    	
    	<form:hidden path="registrationType" value="${registrationType}"  />
    	
    	<form:button>Validate Employee</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>