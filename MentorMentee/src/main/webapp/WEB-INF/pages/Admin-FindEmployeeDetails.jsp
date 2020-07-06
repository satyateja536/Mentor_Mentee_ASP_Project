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
    
    	<div>
    	<h4>Find Employee By Id: </h4>
    	<form:form method="post" action="findEmployee.htm" commandName="formInputs">    
    	    	
    		Enter Employee Id: <br>   	
    		<form:input path="employeeId" />
    		<br> 	  
    		<br>	
    		
    		<form:hidden path="flag" value="ID"  />    		
    	    	
    		<form:button>Find Employee By ID</form:button>    	
    	
		</form:form>
		</div>    
		<br>
		<br>
		<div>
    	<h4>Find Employee By Email: </h4>
    	<form:form method="post" action="findEmployee.htm" commandName="formInputs">    
    	    	
    		Enter Employee Email: <br>   	
    		<form:input path="email" />
    		<br> 	  
    		<br>	
    		
    		<form:hidden path="flag" value="Email"  />
    	    	
    		<form:button>Find Employee By Email</form:button>    	
    	
		</form:form>
		</div>    
		
	</div>

</body>
</html>