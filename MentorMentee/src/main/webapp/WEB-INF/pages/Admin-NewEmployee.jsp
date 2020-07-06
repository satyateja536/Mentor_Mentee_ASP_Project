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
    
    <h4>Enter Employee Details: </h4>
    <form:form method="post" action="newEmployee.htm" commandName="employee">
    
    	    	
    	Enter Employee Name: <br>   	
    	<form:input path="employeeName" />
    	<br> 	  
    	<br> 
    	
    	Enter Employee Email: <br>   	
    	<form:input path="email" />
    	<br> 	  
    	<br> 
    	
    	Enter Employee Phone: <br>   	
    	<form:input path="phone" />
    	<br> 	  
    	<br> 
    	
    	Employee Designation: <br> 
    	<form:select path="employeeDesignation">
    		<c:forEach items="${designations}" var="designation">
               			<form:option value="${designation.designationName}">${designation.designationName}</form:option>
            </c:forEach>
    	</form:select>    	
    	<br> 	  
    	<br> 
    	
    	Employee Reports To: <br> 
    	<form:select path="reportsTo">
    		<c:forEach items="${managersList}" var="manager">
               			<form:option value="${manager.employeeId}">${manager.employeeName}</form:option>
            </c:forEach>
    	</form:select>    	
    	<br> 	  
    	<br>     
    	
    	Employee Is Manager: <br>  
    	<form:select path="isManager">    		
           		<form:option value="yes">Yes</form:option>
           		<form:option value="no">No</form:option>            
    	</form:select>   	
    	<br> 	  
    	<br> 	
    	    	
    	<form:button>Add Employee</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>