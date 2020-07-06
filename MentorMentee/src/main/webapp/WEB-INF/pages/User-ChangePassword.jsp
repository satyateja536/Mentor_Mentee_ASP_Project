<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
    
<!DOCTYPE html>

<html>
<head> 
<link rel="stylesheet" href="<c:url value='/resources/css/table.css'/>">
<script type="text/javascript">
  function checkForm(form)
  {
	if(form.oldPassword.value == "") {
      alert("Error: Old Password cannot be blank!");
      form.oldPassword.focus();
      return false;
    }	
	if(form.oldPassword.value != form.newPassword.value){
		
		if(form.newPassword.value != "" && form.newPassword.value == form.rePassword.value) {			
			return true;
		}
		else {
			alert("Error: Please check that you've entered and confirmed your password!");
			form.newPassword.focus();
			return false;
		}
		
	}
	else{
	  alert("Error: New Password cannot be same as old password!");
      form.newPassword.focus();
      return false;		
	}	
  }
</script>

<title>User Password Change Page</title>
</head>
<body>	 
    <div>
    	${errorMsg}
    	<form:form method="post" action="userPasswordChange.htm" commandName="passwordInputs" onsubmit="return checkForm(this);">
    	
    	<div>
    		<form:label path="oldPassword" > Enter Old Password</form:label>
    		<br>
    		<form:password path="oldPassword" name="oldPassword" />
    	</div>
    	<br>
    	<div>
    		<form:label path="newPassword"> Enter New Password</form:label>
    		<br>
    		<form:password path="newPassword" name="newPassword"/>
    	</div>
    	<br>
    	<div>
    		<form:label path="rePassword">Re Enter New Password</form:label>
    		<br>
    		<form:password path="rePassword" name="rePassword"/>    	
    	</div>
    	<br>
    	    	
    	<form:button>Change Password</form:button>     	
    	
		</form:form>
		
	</div>
     

</body>
</html>