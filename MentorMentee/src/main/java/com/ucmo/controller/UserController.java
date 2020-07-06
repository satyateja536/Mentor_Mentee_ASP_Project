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
import org.springframework.web.servlet.ModelAndView;

import com.ucmo.dto.Employee;
import com.ucmo.dto.PasswordInputs;
import com.ucmo.dto.User;
import com.ucmo.service.EmployeeService;
import com.ucmo.service.UserService;

@Controller

public class UserController {
	
	private static final Logger logger = Logger.getLogger(MentorController.class);
	
	public UserController() {
        logger.info("User-Controller()");
    }
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	

	
	

	/************************* User Page **************************/
	
	@RequestMapping(value = "/userPage")
    public ModelAndView userPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
		
		logger.info("Inside User Controller: userPage Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");		
		User user = userService.getUser(username).get(0);
		Employee userEmployee = employeeService.getEmployee(user.getEmployeeId());
		String manager = employeeService.getManager(user.getEmployeeId());
		
		
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");
		modelMap.addAttribute("manager", manager);
		modelMap.addAttribute("userEmployee", userEmployee);
		modelMap.addAttribute("user", user);		
        return new ModelAndView("User-DetailsPage", modelMap);
    }
	
	@RequestMapping(value = "/userMenteeStatusChange")
    public ModelAndView userMenteeStatusChange(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("user")User user) throws IOException {  
		
		logger.info("Inside User Controller: userMenteeStatusChange Method");
		
		User userReq = userService.getUser(user.getUsername()).get(0);
		
		userReq.setMenteeStatus(user.getMenteeStatus());
		
		userService.updateUser(userReq);
		
		ModelAndView modelView;
		modelView = userPage(request, response);		
			
        return modelView;
    }
	
	
	@RequestMapping(value = "/userMentorStatusChange")
    public ModelAndView userMentorStatusChange(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("user")User user) throws IOException {  
		
		logger.info("Inside User Controller: userMentorStatusChange Method");
		
		User userReq = userService.getUser(user.getUsername()).get(0);
		
		userReq.setMentorStatus(user.getMentorStatus());
		
		userService.updateUser(userReq);
		
		ModelAndView modelView;
		modelView = userPage(request, response);		
			
        return modelView;
    }
	
	@RequestMapping(value = "/userPasswordChangePage")
    public ModelAndView userPasswordChangePage(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("user")User user) throws IOException {  		
		
		logger.info("Inside User Controller: userPasswordChangePage Method");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("passwordInputs", new PasswordInputs());
			
        return new ModelAndView("User-ChangePassword",modelMap);
    }
	
	@RequestMapping(value = "/userPasswordChange")
    public ModelAndView userPasswordChange(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("passwordInputs")PasswordInputs passwordInputs) throws IOException {  
		
		logger.info("Inside User Controller: userPasswordChange Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		User user = userService.getUser(username).get(0);
		
		
		ModelAndView modelView;
		
		if(user.getPassword().equals(passwordInputs.getOldPassword())) {
			user.setPassword(passwordInputs.getNewPassword());
			userService.updateUser(user);
			modelView = userPage(request, response);
		}
		else {
			ModelMap modelMap = new ModelMap();
			modelMap.addAttribute("errorMsg", "Previous Password is Incorrect");
			modelView = new ModelAndView("User-ChangePassword",modelMap);
		}
			
			
        return modelView;
    }
	
	@RequestMapping(value = "/userLogout")
	public ModelAndView userLogout(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		logger.info("Inside User Controller: userLogout Method");

		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		ModelMap modelMap=new ModelMap();
		modelMap.addAttribute("user",new User());
		return new ModelAndView("User-LoginPage",modelMap);
		
	}
	
}
