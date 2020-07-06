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
    			</tr>
    			<tr>
    				<td>${menteeRequestDetails.programName}</td>
    				<td>${menteeRequestDetails.courseLevel}</td>
    				<td>${menteeRequestDetails.courseGroup}</td>    				
    			</tr>
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Mentor Details </p>
    		<table>
    			<tr>
    				<th>Mentor Name</th>    				
    				<th>Email</th>
    			</tr>
    			<tr>
    				<td>${menteeRequestDetails.mentorName}</td>
    				<td>${menteeRequestDetails.mentorEmail}</td>    				
    			</tr>    			
    		</table>    	
    	</div>
    	<br><br>
    	<div>
    		<p> Your Comments: </p>
    		<table>
    			<tr>
    				<td>${menteeRequestDetails.requestComments}</td>
    			</tr>    		    				   			
    		</table>    	
    	</div>    	
    	<br>    	 
    	
    	<div hidden="True">
    		<table>    			
    			<tr>
    				<td></td>
    				<c:if test="${menteeRequestDetails.requestStatus == 'Waiting'}">
    				Status : ${menteeRequestDetails.requestStatus}
    				<br>
    				<td align="center">
    					<form:form method="post" action="menteeProcessRequest.htm" commandName="menteeRequestDetails">
    	
    							<form:hidden path="requestId" />    							
    							<form:hidden path="programId" />
    							<form:hidden path="requestStatus" value="Withdrwan"/>   	
    	   	    	
    							<form:button>Withdraw Request</form:button>       	
						</form:form>
    				</td>
    				</c:if>
    				<td></td>    				
    			</tr>    		
    		</table>    	
    	</div>    
    </div>

</body>
</html>