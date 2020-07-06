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
    			<th>Program Name</th>
    			<th>No Of Enrolled Mentees</th>
    			<th>No Of Available Positions</th>
    		</tr>
    		<c:forEach items="${programsList}" var="prgm">
               	<tr>               		              		
               		<td>${prgm.programName}</td>
               		<td>${prgm.enrolledNoOfMentees}</td>
               		<td>
               			<%
               				Program prgmTemp = (Program)pageContext.findAttribute("prgm");
               				int difference = prgmTemp.getAllowedNoOfMentees() - prgmTemp.getEnrolledNoOfMentees();
               				if(difference <= 0)
               					out.print(0);
               				else
               					out.print(difference);
               			%>
               		</td>               		               		               		
               	</tr>
            </c:forEach>
    		<tr>
    			<td>  </td>
    			<td  align="center">
    				<form:form method="post" action="mentorGetCoursePage.htm" commandName="program" >    	    		
    					
    					<form:button>Add Program</form:button>    		
    					    	
					</form:form> 
    			</td>      			  			
    			<td  align="center">
    				<form:form method="post" action="mentorDisplayPrograms.htm" commandName="program" >    	    		
    					
    					<form:button>View Programs</form:button>    		
    					    	
					</form:form> 
    			</td>
    		</tr>
    	</table>    	
    </div>
    <br>
    <div>
    	<h4> Requests  </h4> 
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>No of Requests</th>
    			<th>View Requests</th>
    		</tr>    	
    		<c:forEach items="${requestInputsList}" var="requestInput">
               	<tr>               		              		
               		<td>${requestInput.programName}</td>
               		<td>${requestInput.noOfRequests}</td>
               		<td  align="center">
    				<form:form method="post" action="mentorViewProgramRequests.htm" commandName="program" >    	    		
    					
    					<form:hidden path="programId" value ="${requestInput.programId}"/>
    					<form:hidden path="programName" value ="${requestInput.programName}"/>
    					<form:button>View Requests</form:button>    		
    					    	
					</form:form> 
    				</td>              		               		               		
               	</tr>
            </c:forEach>	    		
    	</table>    
    </div>
    <br>
    <div>
    	<h4> Sessions  </h4> 
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>No of Sessions</th>
    			<th>View Sessions</th>
    		</tr>    	
    		<c:forEach items="${sessionInputsList}" var="sessionInput">
               	<tr>               		              		
               		<td>${sessionInput.programName}</td>
               		<td>${sessionInput.noOfRequests}</td>
               		<td  align="center">
    				<form:form method="post" action="mentorViewProgramSessions.htm" commandName="program" >    	    		
    					
    					<form:hidden path="programId" value ="${sessionInput.programId}"/>
    					<form:hidden path="programName" value ="${sessionInput.programName}"/>
    					<form:button>View Sessions</form:button>    		
    					    	
					</form:form> 
    				</td>              		               		               		
               	</tr>
            </c:forEach>	    		
    	</table>    
    </div>    
    
    <div>
    	<h4> History  </h4> 
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>No of Closed Sessions</th>
    			<th>View Sessions History</th>
    		</tr>    	
    		<c:forEach items="${historyInputsList}" var="historyInput">
               	<tr>               		              		
               		<td>${historyInput.programName}</td>
               		<td>${historyInput.noOfRequests}</td>
               		<td  align="center">
    				<form:form method="post" action="mentorViewHistoySessions.htm" commandName="program" >    	    		
    					
    					<form:hidden path="programId" value ="${historyInput.programId}"/>
    					<form:hidden path="programName" value ="${historyInput.programName}"/>
    					<form:button>View History</form:button>    		
    					    	
					</form:form> 
    				</td>              		               		               		
               	</tr>
            </c:forEach>	    		
    	</table>    
    </div>     
    
</body>
</html>