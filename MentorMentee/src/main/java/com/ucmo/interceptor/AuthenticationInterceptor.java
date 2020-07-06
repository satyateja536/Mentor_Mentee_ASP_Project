package com.ucmo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = Logger.getLogger(AuthenticationInterceptor.class);	

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Inside AuthenticationInterceptor : Pre-Handle Method");		
		
		HttpSession session=request.getSession();
		
		 String uri = request.getRequestURI();
		 
		 System.out.println("URI: "+uri);
		 		 
		
		 
		 if(!uri.endsWith("main.htm") && !uri.endsWith("mentorIntro.htm") && !uri.endsWith("menteeIntro.htm") 
				 && !uri.endsWith("validateEmployeePage.htm") && !uri.endsWith("validateEmployee.htm")
				 && !uri.endsWith("registration.htm") && !uri.endsWith("loginPage.htm")
				 && !uri.endsWith("authentication.htm") && !uri.endsWith("userLogout.htm") && !uri.endsWith(".css"))
		   {
    		    String user = (String)request.getSession().getAttribute("user");
			    if(user==null)
			    {
			     response.sendRedirect("loginPage.htm");
			     return false;
			    }  
			}
		 
		 if(uri.endsWith("adminHome.htm") || uri.endsWith("newEmployeePage.htm") || uri.endsWith("newEmployee.htm")
				 || uri.endsWith("getEmployeeDetailsPage.htm") || uri.endsWith("getEmployeeDetails.htm")
				 || uri.endsWith("modifyEmployee.htm") || uri.endsWith("findEmployeePage.htm")
				 || uri.endsWith("findEmployee.htm") || uri.endsWith("getUserDetailsPage.htm")
				 || uri.endsWith("getUserDetails.htm") || uri.endsWith("modifyUser.htm")
				 || uri.endsWith("displayCoursesPage.htm") || uri.endsWith("newCoursePage.htm")
				 || uri.endsWith("editCoursePage.htm") || uri.endsWith("modifyCourse.htm"))
		 {
			 
			 System.out.println(session.getAttribute("role"));
			 if(null==session.getAttribute("role")){
				 response.sendRedirect("loginPage.htm");
				 return false;
			 }
			 
			 
		 }
			   return true;
	}
}
