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
<title>Display Available Sessions</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Displaying All Available Sessions</h4>
    <div>
    	<p>Program:</p> ${programName} 
    	<br><br>
    	<table>
    		<tr>
    			<th>Mentee</th>
    			<th>Manager of Mentee</th>
    			<th>View Session</th>    			
    		</tr>
    		<c:forEach items="${requestDetailsList}" var="requestDetails">
               	<tr>
               		<td>${requestDetails.menteeName}</td>
               		<td>${requestDetails.manager}</td>               		
               		<td  align="center">
    				<form:form method="post" action="mentorViewSession.htm" commandName="requestDetail" >   					
    					
    					<form:hidden path="menteeId" value="${requestDetails.menteeId}"/>
    					<form:hidden path="programId" value="${requestDetails.programId}"/>
    					<form:hidden path="requestStatus" value="${requestDetails.requestStatus}"/>
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