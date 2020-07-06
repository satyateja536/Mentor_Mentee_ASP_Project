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
<title>Display Non Waiting Requests</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Displaying All Non Waiting Requests</h4>
    <div>    	
    	<br><br>
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>Mentor Name</th>
    			<th>Request Status</th>
    			<th>View Request</th>    			
    		</tr>    	
    		<c:forEach items="${menteeRequestInputsList}" var="requestInput">
               	<tr>               		              		
               		<td>${requestInput.programName}</td>
               		<td>${requestInput.mentorName}</td>
               		<td>${requestInput.requestStatus}</td>
               		<td  align="center">
    				<form:form method="post" action="menteeViewProgramRequest.htm" commandName="menteeRequestInput" >    	    		
    					
    					<form:hidden path="requestId" value ="${requestInput.requestId}"/>
    					<form:hidden path="programId" value ="${requestInput.programId}"/>
    					<form:button>View Request</form:button>    		
    					    	
					</form:form> 
    				</td>              		               		               		
               	</tr>
            </c:forEach>	    		
    	</table>  
    </div>    
    
    </div>

</body>
</html>