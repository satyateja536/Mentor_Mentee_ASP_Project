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
<title>View Session Page</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Details: </h4>    	   
    
    	<form:form method="post" action="mentorProcessSession.htm" commandName="programSession">    	
    		
    		<form:hidden path="participantId" />  
    		<form:hidden path="sessionStatus"/>							   	
    		
    	<div>    	
    		<p> Program Details </p> <br>
    		<table>
    			<tr>
    				<th>Program Name</th>
    				<th>Course Level</th>
    				<th>Course Group</th>    				
    			</tr>
    			<tr>
    				<td>${programSession.program.programName}</td>
    				<td>${programSession.course.courseLevel}</td>
    				<td>${programSession.course.courseGroup}</td>    				
    			</tr>
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Session Details </p> <br>
    		<table>
    			<tr>
    				<th>Start Date</th>
    				<th>Duration(In Months)</th>
    				<th>Course Completion Status</th>    				
    			</tr>
    			<tr>
    				<td>${programSession.participant.startDate}</td>
    				<td>${programSession.participant.programDuration}</td>
    				<td>
						<form:select path="courseCompletionStatus" >
								<form:option value="InProgress">InProgress</form:option>
								<form:option value="Finished">Finished</form:option>
								<form:option value="Aborted">Aborted</form:option>
						</form:select>
					</td>    				
    			</tr>
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Mentee Details </p>
    		<table>
    			<tr>
    				<th>Mentee Name</th>
    				<th>Mentee Designation</th>
    				<th>Mentee Email</th>
    				<th>Mentee Phone</th>
    				<th>Manager</th>
    			</tr>
    			<tr>
    				<td>${programSession.mentee.employeeName}</td>
    				<td>${programSession.mentee.employeeDesignation}</td>
    				<td>${programSession.mentee.email}</td>
    				<td>${programSession.mentee.phone}</td>
    				<td>${programSession.manager}</td>
    			</tr>    			
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Mentee Notes: </p>
    		<table>
    			<tr>
    				<td>${programSession.menteeNotes}</td>
    			</tr>    		    				   			
    		</table>    	
    	</div>  
    	<br><br>
    	<div>
    		<p> Mentor Notes: </p>
    		<table>
    			<tr>
    				<td>
    					<form:textarea path="mentorNotes" />
    				</td>
    			</tr>    		    				   			
    		</table>    	
    	</div>    	
    	<br>    	 
    	
    	<div>
    		<table>    			
    			<tr>
    				<td></td>
    				<td align="center">    	   	    	
    					
    					<form:button>Save Session</form:button>
    											
    				</td>
    				<td></td>    				
    			</tr>    		
    		</table>    	
    	</div>  
    	
    	</form:form>
    	  
    </div>

</body>
</html>