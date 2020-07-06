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
    
    <h4>Displaying Employee Details of : ${employee.employeeName} </h4>
    <div>
    	<table>
    		<tr>
    			<td>Employee Id: </td>
    			<td> </td>
    			<td>${employee.employeeId}</td>
    		<tr>
    		<tr>
    			<td>Employee Name: </td>
    			<td> </td>
    			<td>${employee.employeeName}</td>
    		<tr>
    		<tr>
    			<td>Employee Email: </td>
    			<td> </td>
    			<td>${employee.email}</td>
    		<tr>
    		<tr>
    			<td>Employee Phone: </td>
    			<td> </td>
    			<td>${employee.phone}</td>
    		<tr>
    		<tr>
    			<td>Employee Designation: </td>
    			<td> </td>
    			<td>${employee.employeeDesignation}</td>
    		<tr>
    		<tr>
    			<td>Employee Reports To: </td>
    			<td> </td>
    			<td>${managerName}</td>
    		<tr>
    		<tr>
    			<td>Employee Is Manager: </td>
    			<td> </td>
    			<td>${employee.isManager}</td>
    		<tr>
    	
    	</table>    
    </div>    
    
    </div>

</body>
</html>