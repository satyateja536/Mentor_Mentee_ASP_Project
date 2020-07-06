<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
    
<!DOCTYPE html>

<html>
<head> 
<link rel="stylesheet" href="<c:url value='/resources/css/table.css'/>">
<title>User Login Page</title>
</head>
<body>	 
    <div>
    	${errorMsg}
    	<form:form method="post" action="authentication.htm" commandName="user">
    	
    	<div>
    	<form:label path="username"> Enter User Name</form:label>
    	<br>
    	<form:input path="username" />
    	</div>
    	<br>
    	<div>
    	<form:label path="password"> Enter Password</form:label>
    	<br>
    	<form:password path="password"/>  		
    	</div>
    	<br>
    	<form:button>Login</form:button>     	
    	
	</form:form>
    </div>  

</body>
</html>