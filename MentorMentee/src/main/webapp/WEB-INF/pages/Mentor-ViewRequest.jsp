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
<title>View Request Page</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Request Details: </h4>    
    	
    	<div>
    		<p> Program Details </p> <br>
    		<table>
    			<tr>
    				<th>Program Name</th>
    				<th>Course Level</th>
    				<th>Course Group</th>
    				<th>No Of Available Slots</th>
    			</tr>
    			<tr>
    				<td>${requestDetail.programName}</td>
    				<td>${requestDetail.courseLevel}</td>
    				<td>${requestDetail.courseGroup}</td>
    				<td>${requestDetail.noOfAvailableSlots}</td>
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
    				<th>Manager</th>
    			</tr>
    			<tr>
    				<td>${requestDetail.menteeName}</td>
    				<td>${requestDetail.menteeDesignation}</td>
    				<td>${requestDetail.manager}</td>
    			</tr>    			
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Mentee Comments: </p>
    		<table>
    			<tr>
    				<td>${requestDetail.menteeComments}</td>
    			</tr>    		    				   			
    		</table>    	
    	</div>    	
    	<br>    	 
    	
    	<div>
    		<table>    			
    			<tr>
    				<td></td>
    				<td align="center">
    					<form:form method="post" action="mentorProcessRequest.htm" commandName="requestDetail">
    	
    							<form:hidden path="requestId" />
    							<form:hidden path="menteeId"  />
    							<form:hidden path="programId" />
    							<form:hidden path="requestStatus" value="Accepted"/>   	
    	   	    	
    							<form:button>Accept Request</form:button>       	
						</form:form>
    				</td>
    				<td></td>
    				<td align="center">
    					<form:form method="post" action="mentorProcessRequest.htm" commandName="requestDetail">
    	
    							<form:hidden path="requestId" />
    							<form:hidden path="menteeId"  />
    							<form:hidden path="programId" />
    							<form:hidden path="requestStatus" value="Rejected"/>   	
    	   	    	
    							<form:button>Reject Request</form:button>       	
						</form:form>
    				</td>
    			</tr>    		
    		</table>    	
    	</div>    
    </div>

</body>
</html>