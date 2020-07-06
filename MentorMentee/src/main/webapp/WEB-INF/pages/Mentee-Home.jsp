<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ucmo.dto.Program" %>
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
  text-align: center;
  column-span: 2;
}
</style>
<title>Mentor Home Page</title>
</head>
<body>    
	
    <div>
    	<h4> Programs  </h4>
    	<table>    		   		
    		<tr>
    			<td>  </td>
    			<td  align="center">
    				<form:form method="post" action="menteeGetProgramPage.htm" commandName="program" >    	    		
    					
    					<form:button>Join Program</form:button>    		
    					    	
					</form:form> 
    			</td>
    			<td></td>    			
    		</tr>
    	</table>    	
    </div>
    <br>
    <div>
    	<h4> Pending Requests  </h4> 
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>Mentor Name</th>
    			<th>View Request</th>
    		</tr>    	
    		<c:forEach items="${menteeRequestInputsList}" var="requestInput">
               	<tr>               		              		
               		<td>${requestInput.programName}</td>
               		<td>${requestInput.mentorName}</td>
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
    	<br>  
    	<table>
    		<tr>
    		<td></td>
    		<td>
    				<form:form method="post" action="menteeViewAllProgramRequests.htm" commandName="menteeRequestInput" >    	    		
    					    					
    					<form:button>View Other Requests</form:button>    		
    					    	
					</form:form>
    		</td>
    		<td></td>
    		</tr>
    	</table>
    </div>
    <br>
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
    					
    					<form:hidden path="participantId" value ="${sessionInput.participantSessionId}"/>    					
    					<form:button>View Session</form:button>    		
    					    	
					</form:form> 
    				</td>              		               		               		
               	</tr>
            </c:forEach>	    		
    	</table>    
    </div>  
    <br>
    <div>
    	<h4> History  </h4> 
    	<table>
    		<tr>
    			<td></td>
    			<td>
    				<form:form method="post" action="menteeViewHistorySessions.htm" commandName="programParticipant" >    					
    					
    					<form:hidden path="participantId" />   					
    					<form:button>View History</form:button>    		
    					    	
					</form:form>     				
    			</td>
    			<td></td>
    		</tr>    	    		    		
    	</table>    
    </div>  
      
    
</body>
</html>