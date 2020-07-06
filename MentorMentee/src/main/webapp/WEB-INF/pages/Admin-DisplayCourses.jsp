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
<title>Display Available Courses</title>
</head>
<body>	
    <div>
    ${errorMsg} 
    <br>       
    
    <h4>Displaying All Available Courses </h4>
    <div>
    	<table>
    		<tr>
    			<th>Name</th>
    			<th>Level</th>
    			<th>Group</th>
    			<th>Status</th>
    			<th>Edit Course</th>
    		</tr>
    		<c:forEach items="${courseList}" var="course">
               	<tr>
               		<td>${course.courseName}</td>
               		<td>${course.courseLevel}</td>
               		<td>${course.courseGroup}</td>
               		<td>${course.courseStatus}</td>
               		<td>
               		<form:form method="post" action="editCoursePage.htm" commandName="course">
    	    		
    					<form:hidden path="courseId" value="${course.courseId}"  />
    					<form:button>Edit Course Status</form:button>    		
    	
					</form:form> 
               		</td>
               	</tr>
            </c:forEach>    		
    		<tr></tr>
    		<tr></tr>
    		<tr>
    			<td></td>
    			<td></td>
    			<td colspan="2" align="center">
    				<form:form method="post" action="newCoursePage.htm" commandName="course" >    	    		
    					
    					<form:button>Add Course</form:button>    		
    					    	
					</form:form> 
    			</td>
    			<td></td>
    			<td></td>
    		</tr>
    	</table>    
    </div>    
    
    </div>

</body>
</html>