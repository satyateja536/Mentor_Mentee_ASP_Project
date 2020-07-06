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
    
    <h4>Modify User Details: </h4>
    <form:form method="post" action="modifyUser.htm" commandName="user">
    
    	Employee Id: ${user.employeeId}
    	<br>
    	<br>
    	UserName: ${user.username}
    	<br> 
    	
    	<form:hidden path="username" />
    	<form:hidden path="password" />
    	<form:hidden path="employeeId" />
    	   		  
    	<br>
    	    	
    	Mentor Status: <br>    	
    	<form:select path="mentorStatus">    		
           		<form:option value="Active">Active</form:option>
           		<form:option value="Inactive">Inactive</form:option>            
    	</form:select>  
    	<br> 	  
    	<br> 
    	
    	Mentee Status: <br>    	
    	<form:select path="menteeStatus">    		
           		<form:option value="Active">Active</form:option>
           		<form:option value="Inactive">Inactive</form:option>            
    	</form:select>  
    	<br> 	  
    	<br>   
    	
    	User Role: <br>    	
    	<form:select path="userRole">    		
           		<form:option value="user">user</form:option>
           		<form:option value="admin">admin</form:option>            
    	</form:select>  
    	<br> 	  
    	<br>   	
    	    	
    	<form:button>Modify User</form:button>    	
    	
	</form:form>
    
    </div>
    <br>
    <div>    	
    	<c:if test="${closeButton == 'visible' }">
    		<form:form method="post" action="closeUser.htm" commandName="user">    	
    		
    				<form:hidden path="username" value="${user.username}" />  
    				<form:hidden path="employeeId" value="${user.employeeId}" />	
    						    					
    				<form:button>Close User</form:button>
    		</form:form>
    	</c:if>
    </div>

</body>
</html>