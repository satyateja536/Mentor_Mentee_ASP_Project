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

<title>${registrationType} Registration Page</title>
</head>
<body>	
    <div>
    	${errorMsg}
    	<br>
    <form:form method="post" action="registration.htm" commandName="formInputs">
    
    	Enter User Name: <br>
    	<form:input path="username" />
    	<br>
    	
    	Enter Password: <br>
    	<form:password path="password"/>    
    	<br>
    		
    	<form:hidden path="employeeId" value="${employeeId}"  />
    	<form:hidden path="registrationType" value="${registrationType}"  />
    	<br>
    	<form:button>Register</form:button>     	
    	
	</form:form>
    </div>
    
</body>
</html>