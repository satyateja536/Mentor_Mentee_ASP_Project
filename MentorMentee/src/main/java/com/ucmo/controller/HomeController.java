package com.ucmo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.dto.Employee;
import com.ucmo.dto.FormInputs;
import com.ucmo.dto.User;
import com.ucmo.service.EmployeeService;
import com.ucmo.service.UserService;

@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	public HomeController() {
        logger.info("Home-Controller()");
    }	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserService userService;	


	
	/************************* Application Home Page **************************/
	@RequestMapping(value = "/main")
    public ModelAndView showMainPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
       
		logger.info("Inside Home Controller: main Method");
		
		return new ModelAndView("Main");
    }
	
	@RequestMapping(value = "/HomePage")
    public ModelAndView HomePage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
       
		logger.info("Inside Home Controller: HomePage Method");
		
		HttpSession httpSession = request.getSession();
		
		
		ModelAndView modelView;
		
		if(null==httpSession.getAttribute("role")){
			modelView = new ModelAndView("User-Home");
		 }
		else {
			modelView = new ModelAndView("Admin-Home");
		}			
		
		return modelView;
    }
	
	/*************************** Application Intro Pages *****************/
	@RequestMapping(value = "/mentorIntro")
    public ModelAndView mentorIntro(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
       
		logger.info("Inside Home Controller: mentorIntro Method");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("formInputs", new  FormInputs());
		return new ModelAndView("Mentor-Intro", modelMap);
    }	
	
	@RequestMapping(value = "/menteeIntro")
    public ModelAndView menteeIntro(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
       
		logger.info("Inside Home Controller: menteeIntro Method");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("formInputs", new  FormInputs());
		return new ModelAndView("Mentee-Intro", modelMap);
    }
	
	/********************* Employee Validation *********************/
	
	@RequestMapping(value = "/validateEmployeePage")
    public ModelAndView validateEmployeePage(HttpServletRequest request, 
    		HttpServletResponse response, 
    		@ModelAttribute("formInputs")FormInputs formInputs) throws IOException { 
		
		logger.info("Inside Home Controller: validateEmployeePage Method");
		
		String regType = formInputs.getRegistrationType();
		System.out.println("Inside ValidateEmployeePage : "+regType);
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("registrationType", regType); 
		modelMap.addAttribute("errorMsg", "");
		modelMap.addAttribute("formInputs", new FormInputs());
		return new ModelAndView("Employee-Validation", modelMap);
    }
	
	@RequestMapping(value = "/validateEmployee")
    public ModelAndView validateEmployee(HttpServletRequest request, 
    		HttpServletResponse response, 
    		@ModelAttribute("formInputs")FormInputs formInputs) throws IOException { 
		
		logger.info("Inside Home Controller: validateEmployee Method");
		
		int empId = formInputs.getEmployeeId();
		String empName = formInputs.getEmployeeName();
		String regType = formInputs.getRegistrationType();
		
		
		int validationStatus = 0;	//Employee is Invalid
		validationStatus = employeeService.validateEmployee(empId, empName);
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		if(validationStatus == 1) {
			modelMap.addAttribute("employeeId", empId);
			modelMap.addAttribute("registrationType", regType);
			modelMap.addAttribute("formInputs", new FormInputs());
			modelView = new ModelAndView("User-Registration", modelMap);		
		}
		else {
			modelMap.addAttribute("registrationType", regType); 
			modelMap.addAttribute("errorMsg", "Invalid Employee");
			modelMap.addAttribute("employee", new Employee());
			modelView = new ModelAndView("Employee-Validation", modelMap);			
		}				
		
		return modelView;
    }
	
	/**************************** User Registration **********************/
	
	@RequestMapping(value = "/registration")
    public ModelAndView registration(HttpServletRequest request, 
    		HttpServletResponse response, 
    		@ModelAttribute("formInputs")FormInputs formInputs) throws IOException {  
       	
		logger.info("Inside Home Controller: registration Method");
		
		System.out.println("Inside Registration 1: ");
		String username = formInputs.getUsername();
		String password = formInputs.getPassword();
		int employeeId = formInputs.getEmployeeId();
		String regType = formInputs.getRegistrationType();
		
		System.out.println("Inside Registration 2: "+regType);
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		int userExistenceStatus = userService.checkUserExistence(username);
		if(userExistenceStatus == 0) {
			String existingUsername = userService.getUsernameByEmployee(employeeId);
			if(existingUsername == null) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmployeeId(employeeId);
				user.setUserRole("user");
				if(regType.equalsIgnoreCase("mentor")) {
					user.setMentorStatus("Active");
					user.setMenteeStatus("Inactive");
				}
				else {
					user.setMenteeStatus("Active");
					user.setMentorStatus("Inactive");
				}
				userService.addUser(user); // User added 
				
				modelMap.addAttribute("errorMsg","Please Log in with the created username: "+user.getUsername());				
			}
			else {
				// username exists for employee
				modelMap.addAttribute("errorMsg", "Employee is already registered with username: "+ existingUsername + " -- Try to Login");
			}
			
			modelMap.addAttribute("user", new User());
			modelView = new ModelAndView("User-LoginPage", modelMap);	
		}
		else {
			// try a different username
			modelMap.addAttribute("errorMsg", username+" already exists try a different one");
			modelMap.addAttribute("employeeId", employeeId);
			modelMap.addAttribute("registrationType", regType);
			modelMap.addAttribute("formInputs", new FormInputs());
			modelView = new ModelAndView("User-Registration", modelMap);	
		}	
		
		return modelView;
    }
	
	
	
	
	
	
	/************************* Application Login **************************/
	@RequestMapping(value = "/loginPage")
    public ModelAndView loginPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 
		
		logger.info("Inside Home Controller: loginPage Method");
		
		ModelMap modelMap = new ModelMap();
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("user", new User());        
        return new ModelAndView("User-LoginPage",modelMap);
    }
	
	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public ModelAndView authentication(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("user")User user)
			throws IOException {		
		
		logger.info("Inside Home Controller: authentication Method");		
		
		HttpSession httpSession = request.getSession();
		
		int userExist = userService.checkUserExistence(user.getUsername());
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		if (userExist == 1) {
			
			User existingUser = userService.getUser(user.getUsername()).get(0);
			
			if(existingUser.getMenteeStatus().equalsIgnoreCase("Closed") || existingUser.getMentorStatus().equalsIgnoreCase("Closed")) {
				modelMap.addAttribute("errorMsg", "User has been terminated - Username: "+user.getUsername()); 
				modelMap.addAttribute("user", new User());        
		        modelView =  new ModelAndView("User-LoginPage",modelMap); 
			}
			else {
				
				System.out.println("Employee Controller- User Exists in the Data Base: ");
				int authenticationStatus = userService.authenticateUser(user.getUsername(), user.getPassword());
					
				if (authenticationStatus == 1) {	
			    	System.out.println("Employee Controller - User is Authenticated");
					int adminStatus = userService.checkAdmin(user.getUsername());					
					if (adminStatus == 1) {
						httpSession.setAttribute("user", user.getUsername());
						httpSession.setAttribute("role", "admin");
						modelView = new ModelAndView("Admin-Home");
					}
					else {					
						httpSession.setAttribute("user", user.getUsername());						
						modelView = new ModelAndView("User-Home");
					}
				} 
				else {
					modelMap.addAttribute("errorMsg", "Authentication Failure. Incorrect User Details "); 
					modelMap.addAttribute("user", new User());        
			        modelView =  new ModelAndView("User-LoginPage",modelMap);					
				}				
			}
		
		} 
		else {
			modelMap.addAttribute("errorMsg", "No User exists with username:  "+user.getUsername()); 
			modelMap.addAttribute("user", new User());        
	        modelView =  new ModelAndView("User-LoginPage",modelMap);
		}		
		
		return modelView;
	 }	
	
	
}
