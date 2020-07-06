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
<title>Display History Sessions</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Displaying Inactive Sessions</h4>
    <div>
    	<h4> Sessions  </h4> 
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>Mentor Name</th>
    			<th>View Session</th>
    		</tr>    	
    		<c:forEach items="${sessionInputsList}" var="sessionInput">
               	<tr>               		              		
               		<td>${sessionInput.programName}</td>
               		<td>${sessionInput.mentorName}</td>
               		<td  align="center">
    				<form:form method="post" action="menteeViewSession.htm" commandName="programParticipant" >    	    		
    					
    					<form:hidden path="participantId" value="${sessionInput.participantSessionId}" />    					
    					<form:button>View Session</form:button>    		
    					    	
					</form:form> 
    				</td>              		               		               		
               	</tr>
            </c:forEach>	    		
    	</table>    
    </div>     
    
    </div>

</body>
</html>