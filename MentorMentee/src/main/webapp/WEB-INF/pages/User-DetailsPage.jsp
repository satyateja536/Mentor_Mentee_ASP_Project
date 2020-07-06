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
<style type="text/css">
	th, td {
  padding: 15px;
  text-align: left;
  column-span: 2;
}
</style>
<title>User Details Page</title>
</head>
<body>	   		
    <div>    	
    	<p> User Details </p> <br>
    	<table>
    		<tr>
    			<td>UserName: </td>
    			<td>${user.username}</td>
    		</tr>
    		<tr>
    			<td>Employee Name: </td>
    			<td>${userEmployee.employeeName}</td>
    		</tr>
    		<tr>
    			<td>Employee Designation: </td>
    			<td>${userEmployee.employeeDesignation}</td>
    		</tr>
    		<tr>
    			<td>Employee Manager: </td>
    			<td>${manager}</td>
    		</tr>
    		<tr>
    			<td>Email: </td>
    			<td>${userEmployee.email}</td>
    		</tr>
    		<tr>
    			<td>Phone: </td>
    			<td>${userEmployee.phone}</td>
    		</tr>
    	</table>    	
    </div>    	
    <br>
    <div>
    	<p> Mentee Status </p>
    	<table>
    		<tr>
    			<td>Mentee Status</td>    			
    			<c:if test="${user.menteeStatus == 'Inactive'}">
    				<td>Status is Inactive</td>
    				<td align="center">
    					<form:form method="post" action="userMenteeStatusChange.htm" commandName="user">    	
    		
    						<form:hidden path="username" />  
    						<form:hidden path="menteeStatus" value="Active"/>	
    						    					
    						<form:button>Activate Mentee Status</form:button>
    					</form:form>
    				</td>
    			</c:if>
    			<c:if test="${user.menteeStatus == 'Active'}">
    				<td>Status is Active</td>    				
    			</c:if>
    		</tr>    			   			
    	</table>    	
    </div>
    <br>
    <div>
    	<p> Mentor Status </p>
    	<table>
    		<tr>
    			<td>Mentor Status</td>    			
    			<c:if test="${user.mentorStatus == 'Inactive'}">
    				<td>Status is Inactive</td>
    				<td align="center">
    					<form:form method="post" action="userMentorStatusChange.htm" commandName="user">    	
    		
    						<form:hidden path="username" />  
    						<form:hidden path="mentorStatus" value="Active"/>	
    						    					
    						<form:button>Activate Mentor Status</form:button>
    					</form:form>
    				</td>
    			</c:if>
    			<c:if test="${user.mentorStatus == 'Active'}">
    				<td>Status is Active</td>    				
    			</c:if>
    		</tr>    			   			
    	</table>    	
    </div>
    <br>
    <div>
    	<table>
    		<tr>
    			<td>Change Password?</td>
    			<td align="center">
    				<form:form method="post" action="userPasswordChangePage.htm" commandName="user"> 	
    						
    					<form:hidden path="username" />     						    					
    					<form:button>Change Password</form:button>
    						
    				</form:form>
    			</td>
    		</tr>
    	</table>
    </div>    	    	     	
    

</body>
</html>