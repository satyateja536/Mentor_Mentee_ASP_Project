package com.ucmo.controller;

import java.io.IOException;
import java.util.List;

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

import com.ucmo.dto.Course;
import com.ucmo.dto.CourseGroup;
import com.ucmo.dto.Designation;
import com.ucmo.dto.EmailNotification;
import com.ucmo.dto.Employee;
import com.ucmo.dto.FormInputs;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.ProgramRequest;
import com.ucmo.dto.User;
import com.ucmo.service.CourseGroupService;
import com.ucmo.service.CourseService;
import com.ucmo.service.DesignationService;
import com.ucmo.service.EmailNotificationService;
import com.ucmo.service.EmployeeService;
import com.ucmo.service.ProgramParticipantService;
import com.ucmo.service.ProgramRequestService;
import com.ucmo.service.ProgramService;
import com.ucmo.service.UserService;

@Controller

public class AdminController {
	
	private static final Logger logger = Logger.getLogger(MentorController.class);
	
	public AdminController() {
        logger.info("Admin-Controller()");
    }
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseGroupService courseGroupService;
	
	@Autowired
	private DesignationService designationService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramParticipantService programParticipantService;
	
	@Autowired
	private EmailNotificationService emailNotificationService;
	
	@Autowired
	private ProgramRequestService programRequestService;
	
	

	/************************* Admin Home  **************************/
	
	
	@RequestMapping(value = "/adminHome")
    public ModelAndView adminHome(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 
		
		logger.info("Inside Admin Controller: adminHome Method");
		        
        return new ModelAndView("Admin-Home");
    }
	
	/************************ Functionalities **************************************/
	
	/***************************** Employee Functionalities ***************************/
	
	@RequestMapping(value = "/newEmployeePage")
    public ModelAndView newEmployeePage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 
		
		logger.info("Inside Admin Controller: newEmployeePage Method");
		
		List<Designation> designations = designationService.getAllDesignations();
		List<Employee> managersList = employeeService.getAllManagers();
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("employee", new Employee());
		modelMap.addAttribute("designations", designations);
		modelMap.addAttribute("managersList", managersList);		        
        return new ModelAndView("Admin-NewEmployee", modelMap);
    }
	
	@RequestMapping(value = "/newEmployee")
    public ModelAndView newEmployee(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("employee")Employee employee) throws IOException { 
		
		logger.info("Inside Admin Controller: newEmployee Method");
		
		List<Designation> designations = designationService.getAllDesignations();
		List<Employee> managersList = employeeService.getAllManagers();
		
		int employeeExistStatus = employeeService.checkEmployeeExistence(employee.getEmail());
		
		ModelMap modelMap = new ModelMap();
		
		
		if(employeeExistStatus == 0) {   // employee doesn't exist with given email
			
			employeeService.addEmployee(employee);
			modelMap.addAttribute("errorMsg", "Employee Added Successfully"); 
			
		}
		else {   //  // employee exists with given email
			
			modelMap.addAttribute("errorMsg", "Email already used : "+employee.getEmail());			
			
		}
		
		modelMap.addAttribute("employee", new Employee());
		modelMap.addAttribute("designations", designations);
		modelMap.addAttribute("managersList", managersList);		
		     
		return new ModelAndView("Admin-NewEmployee", modelMap);
    }
	
	@RequestMapping(value = "/getEmployeeDetailsPage")
    public ModelAndView getEmployeeDetailsPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 		
		
		logger.info("Inside Admin Controller: getEmployeeDetailsPage Method");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("employee", new Employee());			        
        return new ModelAndView("Admin-GetEmployeeDetails", modelMap);
    }
	
	@RequestMapping(value = "/getEmployeeDetails")
    public ModelAndView getEmployeeDetails(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("employee")Employee employee) throws IOException { 		
		
		logger.info("Inside Admin Controller: getEmployeeDetails Method");
		
		int employeeExistStatus = employeeService.validateEmployeeById(employee.getEmployeeId());
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		if(employeeExistStatus == 1) {  // employee exists			
			
			Employee emp = employeeService.getEmployee(employee.getEmployeeId());
			
			List<Designation> designations = designationService.getAllDesignations();
			List<Employee> managersList = employeeService.getAllManagers();
			
			modelMap.addAttribute("errorMsg", ""); 
			//modelMap.addAttribute("empDetails", emp);
			modelMap.addAttribute("employee", emp);
			modelMap.addAttribute("designations", designations);
			modelMap.addAttribute("managersList", managersList);
			modelView = new ModelAndView("Admin-ModifyEmployee", modelMap);
			
		}
		else {
			modelMap.addAttribute("errorMsg", "Employee Does not exist with given Id: "+employee.getEmployeeId());
			modelMap.addAttribute("employee", new Employee());	
			modelView = new ModelAndView("Admin-GetEmployeeDetails", modelMap);
		}		
				        
        return modelView;
    }
	
	
	@RequestMapping(value = "/modifyEmployee")
    public ModelAndView modifyEmployee(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("employee")Employee employee) throws IOException { 
		
		logger.info("Inside Admin Controller: modifyEmployee Method");
		
		employeeService.updateEmployee(employee);
		
		return new ModelAndView("Admin-Home");
		
    }
	
	@RequestMapping(value = "/findEmployeePage")
    public ModelAndView findEmployeePage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 		
		
		logger.info("Inside Admin Controller: findEmployeePage Method");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("formInputs", new FormInputs());			        
        return new ModelAndView("Admin-FindEmployeeDetails", modelMap);
    }
	
	
	@RequestMapping(value = "/findEmployee")
    public ModelAndView findEmployee(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("formInputs")FormInputs formInputs) throws IOException { 		
		
		logger.info("Inside Admin Controller: findEmployee Method");
		
		String flag = formInputs.getFlag();
		String email = formInputs.getEmail();
		int empId = formInputs.getEmployeeId();
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		if(flag.equalsIgnoreCase("email")) { // Find Employee By Email
			int emailExist = employeeService.checkEmployeeExistence(email);
			if(emailExist == 1) {	// Employee Exist with the email
				Employee employee = employeeService.getEmployeeByEmail(email).get(0);
				Employee manager = employeeService.getEmployee(employee.getReportsTo());
				
				modelMap.addAttribute("managerName", manager.getEmployeeName());
				modelMap.addAttribute("employee", employee);
				modelView = new ModelAndView("Admin-DisplayEmployeeDetails",modelMap);
				
			}
			else {		// No Employee for the email
				modelMap.addAttribute("errorMsg", "No Employee exists for the email: "+email); 
				modelMap.addAttribute("formInputs", new FormInputs());	
				modelView = new ModelAndView("Admin-FindEmployeeDetails",modelMap);
			}
		}
		else {		// Find Employee by ID
			
			int empIDexist = employeeService.validateEmployeeById(empId);
			if(empIDexist == 1) {	// Employee exist with ID
				Employee employee = employeeService.getEmployee(empId);
				Employee manager = employeeService.getEmployee(employee.getReportsTo());
				
				modelMap.addAttribute("managerName", manager.getEmployeeName());
				modelMap.addAttribute("employee", employee);
				modelView = new ModelAndView("Admin-DisplayEmployeeDetails",modelMap);
			}
			else {		// No Employee exists for given ID
				modelMap.addAttribute("errorMsg", "No Employee exists for the id: "+empId); 
				modelMap.addAttribute("formInputs", new FormInputs());	
				modelView = new ModelAndView("Admin-FindEmployeeDetails",modelMap);
			}
			
		}	
					        
        return modelView;
    }
	
	/***************************** User Functionalities ***************************/
	
	@RequestMapping(value = "/getUserDetailsPage")
    public ModelAndView getUserDetailsPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 		
		
		logger.info("Inside Admin Controller: getUserDetailsPage Method");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("user", new User());			        
        return new ModelAndView("Admin-GetUserDetails", modelMap);
    }
	
	@RequestMapping(value = "/getUserDetails")
    public ModelAndView getUserDetails(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("user")User user) throws IOException { 		
		
		logger.info("Inside Admin Controller: getUserDetails Method");
		
		HttpSession httpSession = request.getSession();
		String adminUserName = (String) httpSession.getAttribute("user");		
		User admin = userService.getUser(adminUserName).get(0);		
		
		int empId = user.getEmployeeId();
		String username = userService.getUsernameByEmployee(empId);
		
		String closeButton = "hidden"; 
		
		if(admin.getEmployeeId() != empId) {
			closeButton = "visible";
		}
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		if(username != null) {  // user exists
			
			User existingUser = userService.getUser(username).get(0);			
			
			if(existingUser.getMenteeStatus().equalsIgnoreCase("Closed") || existingUser.getMentorStatus().equalsIgnoreCase("Closed")) {
				
				modelMap.addAttribute("errorMsg", "User for given Employee is terminated: "+empId);
				modelMap.addAttribute("user", new User());	
				modelView = new ModelAndView("Admin-GetUserDetails", modelMap);
			}
			else {
				modelMap.addAttribute("errorMsg", ""); 				
				modelMap.addAttribute("user", existingUser);			
				modelMap.addAttribute("closeButton", closeButton);						
				modelView = new ModelAndView("Admin-ModifyUser", modelMap);
			}			
			
		}
		else {   // user does not exist
			modelMap.addAttribute("errorMsg", "User Does not exist for given Employee: "+empId);
			modelMap.addAttribute("user", new User());	
			modelView = new ModelAndView("Admin-GetUserDetails", modelMap);
		}		
				        
        return modelView;
    }
	
	@RequestMapping(value = "/modifyUser")
    public ModelAndView modifyUser(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("user")User user) throws IOException { 
		
		logger.info("Inside Admin Controller: modifyUser Method");
		
		userService.updateUser(user);		
		
		return new ModelAndView("Admin-Home");
		
    }

	/*************** Closing User and all his activities and cannot be reactivated *************/
	
	@RequestMapping(value = "/closeUser")
    public ModelAndView closeUser(HttpServletRequest request, 
    		HttpServletResponse response, @ModelAttribute("user")User user) throws Exception { 
		
		logger.info("Inside Admin Controller: Close Method");
		
		//User as Mentor
		
		//closing all the mentor programs of the user and notifying the participants 
		
		Employee mentor = employeeService.getEmployee(user.getEmployeeId()); 		
		
		List<Program> mentorPrograms = programService.getProgramsByMentor(mentor.getEmployeeId());		
		
		for(Program mentorProgram: mentorPrograms) {
			List<ProgramParticipant> participants = 
					programParticipantService.getAllParticipantsByProgramAndStatus(mentorProgram.getProgramId(), "Active");
			
			if(!participants.isEmpty()) {
			//List<String> menteeMailIds = new ArrayList<String>();
			StringBuilder mailIds = new StringBuilder("");
			
			for(ProgramParticipant participant: participants) {
				int menteeId = participant.getMenteeId();
				String mailId = employeeService.getEmployee(menteeId).getEmail();
				System.out.println("For Loop: Mail Id "+mailId);
				mailIds.append(mailId).append(";");
				//menteeMailIds.add(mailId);
			}
			System.out.println("MailIds :"+mailIds);
			//Populating Email Notification object
			String programName = mentorProgram.getProgramName();
			String mentorName = mentor.getEmployeeName();
			String subject = "Program: '"+programName+"' By "+mentorName+" is closed";
			
			EmailNotification mentorNotification = 
					emailNotificationService.populateEmailNotificationForClosedMentor(mailIds.toString(), subject, mentor, mentorProgram);
			
			//Sending Email Notification to All the participants of the program
			emailNotificationService.sendNotification(mentorNotification);
			
			//Making participants inactive
			programParticipantService.updateParticipantsStatusToInactive(participants);			
			
			}
			//Closing the Program
			mentorProgram.setStatus("Closed");
			programService.updateProgram(mentorProgram);
		}
		
		// User as Mentee
		
		Employee mentee = employeeService.getEmployee(user.getEmployeeId());
		
		List<ProgramParticipant> menteeActiveParticipations = 
				programParticipantService.getAllParticipantsByMenteeAndStatus(mentee.getEmployeeId(), "Active");
		
		if(!menteeActiveParticipations.isEmpty()) {
		for(ProgramParticipant participant : menteeActiveParticipations) {
			Program program = programService.getProgram(participant.getProgramId());
			String mentorMailId = employeeService.getEmployee(program.getMentorId()).getEmail();
			
			String subject = "Mentee '"+mentee.getEmployeeName()+"' of Program '"+program.getProgramName()+"' has left";
			
			EmailNotification menteeNotification = 
					emailNotificationService.populateEmailNotificationForClosedMentee(mentorMailId, subject, mentee, program);
			
			emailNotificationService.sendNotification(menteeNotification);
			programService.decreamentEnrolledNo(program.getProgramId());
		}
		}
		
		// Closing all the participations of Mentee
		List<ProgramParticipant> menteeParticipations = 
				programParticipantService.getAllParticipantsByMentee(mentee.getEmployeeId());
		programParticipantService.updateParticipantsStatusToClosed(menteeParticipations);
		
		// Closing Mentee Waiting Requests
		
		List<ProgramRequest> menteeRequests = programRequestService.getWaitingMenteeRequests(mentee.getEmployeeId());
		programRequestService.updateMenteeRequestsToClosed(menteeRequests);
		
		
		// Notification For User
		
		
		String mailId = mentor.getEmail();
		String subject = "Your account has been Terminated";
		EmailNotification userNotification = 
				emailNotificationService.populateEmailNotificationForClosedUser(mailId, subject, mentor);
		
		emailNotificationService.sendNotification(userNotification);
		
		// Changing user status to closed and cannot be reactivated
		User userTemp = userService.getUser(user.getUsername()).get(0);
		userTemp.setMenteeStatus("Closed");
		userTemp.setMentorStatus("Closed");
		userService.updateUser(userTemp);
		
		
		return new ModelAndView("Admin-Home");
		
    }
	
	
	/***************************** Course Functionalities ***************************/
	
	@RequestMapping(value = "/displayCoursesPage")
    public ModelAndView displayCoursesPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 	
		
		logger.info("Inside Admin Controller: displayCoursesPage Method");
		
		List<Course> courseList = courseService.getAllCourses();
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("courseList", courseList);
		modelMap.addAttribute("course", new Course());
        return new ModelAndView("Admin-DisplayCourses", modelMap);
    }
	
	@RequestMapping(value = "/newCoursePage")
    public ModelAndView newCoursePage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException { 		
		
		logger.info("Inside Admin Controller: newCoursePage Method");
		
		List<CourseGroup> groupList = courseGroupService.getAllCourseGroups();
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("groupList", groupList);
		modelMap.addAttribute("course", new Course());
        return new ModelAndView("Admin-NewCourse", modelMap);
    }
	
	@RequestMapping(value = "/newCourse")
    public ModelAndView newCourse(HttpServletRequest request, 
    		HttpServletResponse response, 
    		@ModelAttribute("course")Course course) throws IOException { 		
		
		logger.info("Inside Admin Controller: newCourse Method");
		
		int courseExistStatus = courseService.checkDupicateCourse(course);
		
		ModelMap modelMap = new ModelMap();
		ModelAndView modelView;
		
		if(courseExistStatus == 1) { 	// Course Does not exist
			
			courseService.addCourse(course);
			List<Course> courseList = courseService.getAllCourses();		
			
			modelMap.addAttribute("errorMsg", "Course Added Successfully"); 
			modelMap.addAttribute("courseList", courseList);
			modelMap.addAttribute("course", new Course());
			modelView = new ModelAndView("Admin-DisplayCourses", modelMap);
			
		}
		else {		// Course Already Exists
			
			List<CourseGroup> groupList = courseGroupService.getAllCourseGroups();
			
			modelMap.addAttribute("errorMsg", "Course Already exist with name: "+course.getCourseName()); 
			modelMap.addAttribute("groupList", groupList);
			modelMap.addAttribute("course", new Course());
			modelView = new ModelAndView("Admin-NewCourse", modelMap);
		}	
			
        return modelView;
    }
	
	@RequestMapping(value = "/editCoursePage")
    public ModelAndView editCoursePage(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("course")Course course) throws IOException { 		
		
		logger.info("Inside Admin Controller: editCoursePage Method");
		
		Course existingCourse = courseService.getCourse(course.getCourseId());	
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", ""); 
		modelMap.addAttribute("course", existingCourse);
        return new ModelAndView("Admin-ModifyCourse", modelMap);
    }
	
	@RequestMapping(value = "/modifyCourse")
    public ModelAndView modifyCourse(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("course")Course course) throws IOException { 		
		
		logger.info("Inside Admin Controller: modifyCourse Method");
		
		courseService.updateCourse(course);	
		
		List<Course> courseList = courseService.getAllCourses();
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "Course Modified"); 		
		modelMap.addAttribute("courseList", courseList);
		modelMap.addAttribute("course", new Course());
		return new ModelAndView("Admin-DisplayCourses", modelMap);
    }
	
	
}
