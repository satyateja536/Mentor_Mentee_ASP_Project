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
<title>Display Mentor Programs</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Displaying All Available Programs </h4>
    <div>
    	<table>
    		<tr>
    			<th>Program Name</th>
    			<th>Duration</th>
    			<th>Allowed No Of Mentees</th>
    			<th>Program Notes</th>
    			<th>Status</th>
    			<th>Edit Program</th>
    		</tr>
    		<c:forEach items="${programsList}" var="prgm">
               	<tr>
               		<td>${prgm.programName}</td>
               		<td>${prgm.duration}</td>
               		<td>${prgm.allowedNoOfMentees}</td>
               		<td>${prgm.mentorProgramNotes}</td>
               		<td>${prgm.status}</td>
               		<td>
               		<form:form method="post" action="mentorModifyProgramPage.htm" commandName="program">
    	    		
    					<form:hidden path="programId" value="${prgm.programId}"  />
    					<form:button>Edit Program</form:button>    		
    	
					</form:form> 
               		</td>
               	</tr>
            </c:forEach>     		
    	</table>    
    </div>    
    
    </div>

</body>
</html>