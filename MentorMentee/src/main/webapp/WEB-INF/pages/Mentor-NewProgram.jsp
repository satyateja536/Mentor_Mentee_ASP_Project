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
<title>New Program Page</title>
</head>
<body>	
    <div >
    ${errorMsg} 
    <br>       
    
    <h4>Enter Employee Details: </h4>
    <form:form method="post" action="mentorNewProgram.htm" commandName="program">
    
    	Course Name: ${program.programName}<br>
    	
    	<form:hidden path="programId"/>
    	<form:hidden path="mentorId" />
    	<form:hidden path="programName" />
    	<form:hidden path="status"  />
    	<form:hidden path="enrolledNoOfMentees" value="0" />
    	<br>
    	
    	<p>Select Course Level and Group:</p>
    	<div>    	
    		<table>
    			<tr>    			
    				<th>Level</th>
    				<th>Group</th>    			
    				<th>Select Course</th>
    			</tr>
    			<c:forEach items="${courseList}" var="course">
               		<tr>               		
               			<td>${course.courseLevel}</td>
               			<td>${course.courseGroup}</td>               		
               			<td>
               				<form:radiobutton path="courseId" value="${course.courseId}"/>               		
               			</td>
               		</tr>
            	</c:forEach>    		
    			<tr></tr>    		
    		</table>       	    	
    	</div>
    	<br>    	  	
    	Program Duration in Months: <br>
    	<br>  
    	<form:select path="duration">    		
           		<form:option value="1">1</form:option>
           		<form:option value="2">2</form:option>
           		<form:option value="3">3</form:option>            
    	</form:select> 
    	<br> 	  
    	<br>
    	
    	No Of Mentees Allowed: <br> 
    	<br> 
    	<form:select path="allowedNoOfMentees">    		
           		<form:option value="1">1</form:option>
           		<form:option value="2">2</form:option>
           		<form:option value="3">3</form:option>
           		<form:option value="4">4</form:option>            
    	</form:select> 
    	<br> 	  
    	<br>  
    	
    	Any Comments Related to Program: <br> 
    	<br>  	
    	<form:textarea path="mentorProgramNotes" />
    	<br> 	  
    	<br>     		
    	    	
    	<form:button>Add Program</form:button>    	
    	
	</form:form>
    
    </div>

</body>
</html>