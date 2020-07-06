<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/table.css'/>">

<title>Admin Home Page</title>

</head>
<body>	
    <div id="content">
    <div>
    	<h4> Employee Functionalities </h4> 
    	<table>    		
    		<tr>  
    		<td> </td> 		
    		<td> <a href="newEmployeePage.htm">New Employee</a> </td>
    		<td> </td>
    		<td> To Create a New Employee </td>
    		</tr>
    		<tr>
    		<td> </td>
    		<td> <a href="getEmployeeDetailsPage.htm">Modify Employee</a> </td>
    		<td> </td>
    		<td> To Modify an Existing Employee </td>   		
    		</tr>
    		<tr>
    		<td> </td>
    		<td> <a href="findEmployeePage.htm">Find Employee</a> </td>
    		<td> </td>
    		<td> To Find an Existing Employee </td>    		
    		</tr>
    	</table>    
    </div>
    <br>
    <div>
    	<h4> User Functionalities </h4>
    	<table>
    		<tr>
    		<td></td>
    		<td> <a href="getUserDetailsPage.htm">Edit User</a> </td>
    		<td></td>
    		<td> To Edit an Existing User</td>    		    		
    		</tr>
    	</table>    	
    </div>
    <br>
    <div>
    	<h4> Course Functionalities </h4>
    	<table>
    		<tr>
    		<td></td>
    		<td> <a href="displayCoursesPage.htm">Add or Modify Course</a> </td>
    		<td></td>
    		<td> To Add a New or Modify an Existing Course</td>    		
    		</tr>
    	</table>    	
    </div>
    
    </div>
</body>
</html>