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
    
    	<form:form method="post" action="menteeProcessSession.htm" commandName="menteeProgramSession">    	
    		
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
    				<td>${menteeProgramSession.program.programName}</td>
    				<td>${menteeProgramSession.course.courseLevel}</td>
    				<td>${menteeProgramSession.course.courseGroup}</td>    				
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
    				<td>${menteeProgramSession.participant.startDate}</td>
    				<td>${menteeProgramSession.participant.programDuration}</td>
    				<td>${menteeProgramSession.participant.courseCompletionStatus}</td>    				
    			</tr>
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Mentor Details </p>
    		<table>
    			<tr>
    				<th>Mentor Name</th>
    				<th>Mentor Designation</th>
    				<th>Mentor Email</th>
    				<th>Mentor Phone</th>    				
    			</tr>
    			<tr>
    				<td>${menteeProgramSession.mentor.employeeName}</td>
    				<td>${menteeProgramSession.mentor.employeeDesignation}</td>
    				<td>${menteeProgramSession.mentor.email}</td>
    				<td>${menteeProgramSession.mentor.phone}</td>    				
    			</tr>    			
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Mentor Notes: </p>
    		<table>
    			<tr>
    				<td>${menteeProgramSession.mentorNotes}</td>
    			</tr>    		    				   			
    		</table>    	
    	</div>  
    	<br><br>
    	<div>
    		<p> Mentee Notes: </p>
    		<table>
    			<tr>
    				<td>
    					<form:textarea path="menteeNotes" />
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