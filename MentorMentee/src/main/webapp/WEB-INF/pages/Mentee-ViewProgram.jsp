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
<title>View Program Page</title>
</head>
<body>
    <div >
    ${errorMsg} 
    <br>       
    
    <h4>View Program Details: </h4>
    	
    	<div>
    		<table>
    			<tr>
    				<td>Program :</td>
    				<td>${program.programName}</td>
    			</tr>
    			<tr>
    				<td>Mentor :</td>
    				<td>${mentorName}</td>
    			</tr>
    			<tr>
    				<td>Program Group :</td>
    				<td>${courseGroup}</td>
    			</tr>
    			<tr>
    				<td>Program Duration(In Months)</td>
    				<td>${program.duration}</td>
    			</tr>
    			<tr>
    				<td>About Course</td>
    				<td>${program.mentorProgramNotes}</td>
    			</tr>      					
    		</table>    	
    	</div>
       
    	<form:form method="post" action="menteeJoinProgram.htm" commandName="programRequest">   	
    	
    		<form:hidden path="programId" value="${program.programId}" />    		
    		<form:textarea path="menteeComments" />  
    		
    		<form:button>Join Program</form:button>   		
    	
    	</form:form>
    
    </div>

</body>
</html>