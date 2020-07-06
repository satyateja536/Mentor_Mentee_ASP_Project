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
<title>Display Program Mentors </title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Displaying All Available Mentors </h4>
    <div>
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>Mentor Name</th>
    			<th>Duration(In Months)</th>    			
    			<th>View Program</th>
    		</tr>
    		<c:forEach items="${menteeInputList}" var="menteeInput">
               	<tr>
               		<td>${menteeInput.programName}</td>
               		<td>${menteeInput.mentorName}</td>
               		<td>${menteeInput.programDuration}</td>               		
               		<td>
               		<form:form method="post" action="menteeViewProgram.htm" commandName="program">
    	    		
    					<form:hidden path="programId" value="${menteeInput.programId}"  />
    					<form:button>View Program</form:button>    		
    	
					</form:form> 
               		</td>
               	</tr>
            </c:forEach>     		
    	</table>    
    </div>    
    
    </div>

</body>
</html>