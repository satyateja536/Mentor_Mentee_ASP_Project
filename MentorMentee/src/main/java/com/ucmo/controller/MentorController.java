package com.ucmo.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.ProgramRequest;
import com.ucmo.dto.ProgramSession;
import com.ucmo.dto.RequestDetails;
import com.ucmo.dto.RequestInputs;
import com.ucmo.dto.User;
import com.ucmo.service.CourseService;
import com.ucmo.service.EmployeeService;
import com.ucmo.service.ProgramParticipantService;
import com.ucmo.service.ProgramRequestService;
import com.ucmo.service.ProgramService;
import com.ucmo.service.ProgramSessionService;
import com.ucmo.service.RequestDetailsService;
import com.ucmo.service.RequestInputsService;
import com.ucmo.service.UserService;

@Controller
public class MentorController {
	
	private static final Logger logger = Logger.getLogger(MentorController.class);
	
	public MentorController() {
        logger.info("Mentor-Controller()");
    }
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProgramRequestService programRequestService;
	
	@Autowired
	private ProgramParticipantService programParticipantService;
	
	@Autowired
	private RequestInputsService requestInputsService;
	
	@Autowired
	private RequestDetailsService requestDetailsService;
	
	@Autowired
	private ProgramSessionService programSessionService;
	

	/************************* Mentor Home Page **************************/
	
	@RequestMapping(value = "/mentorPage")
    public ModelAndView mentorPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorPage Method");	
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int mentorId = userService.getUser(username).get(0).getEmployeeId();
		
		User mentor = userService.getUser(username).get(0);	
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");
		
		/**************************** Home Page Program *************************************/
		
		List<Program> programsList = programService.getProgramsByMentor(mentorId);
		modelMap.addAttribute("programsList", programsList);
		modelMap.addAttribute("program", new Program());
       
		
		/**************************** Home Page Request *************************************/
		
		List<RequestInputs> requestInputsList = requestInputsService.getAllRequestInputs(programsList);	
		
		modelMap.addAttribute("requestInputsList", requestInputsList);
		
		/**************************** Home Page Session *************************************/
		
		List<RequestInputs> sessionInputsList = requestInputsService.getAllSessionInputs(programsList);		
		
		modelMap.addAttribute("sessionInputsList", sessionInputsList);
		 
		/**************************** Home Page History *************************************/
		
		List<RequestInputs> historyInputsList = requestInputsService.getAllHistoryInputs(programsList);		
		
		modelMap.addAttribute("historyInputsList", historyInputsList);
		
		ModelAndView modelView;
		
		if(mentor.getMentorStatus().equalsIgnoreCase("Inactive")) {
			modelMap.addAttribute("user", mentor);
			modelView = new ModelAndView("Mentor-ActivationPage", modelMap);
		}
		else {
			modelView = new ModelAndView("Mentor-Home", modelMap);
		}
		
        return modelView;
    }
	
	@RequestMapping(value = "/mentorStatusChangeToActive")
    public ModelAndView mentorStatusChangeToActive(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("user")User user) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeActivationStatus Method");
		
		User userReq = userService.getUser(user.getUsername()).get(0);
		
		userReq.setMentorStatus("Active");
		
		userService.updateUser(userReq);
		
		ModelAndView modelView;
		modelView = mentorPage(request, response);
			
        return modelView;
    }
	
	/***************************************** Program **********************************************/
	
	@RequestMapping(value = "/mentorGetCoursePage")
    public ModelAndView mentorGetCoursePage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorGetCoursePage Method");	
		
		List<String> courseNames = courseService.getDistinctCourseNamesByStatus("Active");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("courseNames", courseNames);	
		modelMap.addAttribute("course", new Course());
        return new ModelAndView("Mentor-GetCourseDetails", modelMap);
    }
	
	@RequestMapping(value = "/mentorNewProgramPage")
    public ModelAndView mentorNewProgramPage(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("course")Course course) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorNewProgramPage Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int mentorId = userService.getUser(username).get(0).getEmployeeId(); 
		
		List<Course> courseList = courseService.getAciveCourseByName(course.getCourseName());		
		Program program = new Program();
		program.setProgramName(course.getCourseName());
		program.setMentorId(mentorId);
		program.setStatus("Active");
		
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");		
		modelMap.addAttribute("courseList", courseList);		
		modelMap.addAttribute("program", program);
        return new ModelAndView("Mentor-NewProgram", modelMap);
    }
	
	@RequestMapping(value = "/mentorNewProgram")
    public ModelAndView mentorNewProgram(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorNewProgram Method");
		
		//Program tempProgram = new Program();
		 
		Course course = courseService.getCourse(program.getCourseId());
		String name = program.getProgramName()+"-"+course.getCourseLevel();
		program.setProgramName(name);
		
		int duplicateStatus = programService.checkDupicateProgram(program);
		
		
		ModelMap modelMap = new ModelMap();		
		
		if(duplicateStatus == 1) {  // Program does not exist
			programService.addProgram(program);
			
			modelMap.addAttribute("errorMsg", "Program Added Successfully");			
			
		}
		else {	// Program already exists
			
			modelMap.addAttribute("errorMsg", "Program Already exists with Same Course Details: "+program.getProgramName());	
			
		}
		
		List<String> courseNames = courseService.getDistinctCourseNamesByStatus("Active");		
				
		modelMap.addAttribute("courseNames", courseNames);	
		modelMap.addAttribute("course", new Course());			
		
        return new ModelAndView("Mentor-GetCourseDetails", modelMap);
		
    }
	
	@RequestMapping(value = "/mentorDisplayPrograms")
    public ModelAndView mentorDisplayPrograms(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorDisplayPrograms Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int mentorId = userService.getUser(username).get(0).getEmployeeId();
		
		
		List<Program> programsList = programService.getProgramsByMentor(mentorId);
		
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("programsList", programsList);
		modelMap.addAttribute("program", new Program());
        return new ModelAndView("Mentor-DisplayPrograms", modelMap);
    }
	
	@RequestMapping(value = "/mentorModifyProgramPage")
    public ModelAndView mentorModifyProgramPage(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorModifyProgramPage Method");
				
		Program existingProgram = programService.getProgram(program.getProgramId());
		
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("program", existingProgram);		
        return new ModelAndView("Mentor-ModifyProgram", modelMap);
    }
	
	@RequestMapping(value = "/mentorModifyProgram")
    public ModelAndView mentorModifyProgram(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
				
		logger.info("Inside Mentor Controller: mentorModifyProgram Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int mentorId = userService.getUser(username).get(0).getEmployeeId();
		
		programService.updateProgram(program);	// Program Modified	
		
		
		List<Program> programsList = programService.getProgramsByMentor(mentorId);
		
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "Successfully Modified Program with Name: "+program.getProgramName());			
		modelMap.addAttribute("programsList", programsList);
		modelMap.addAttribute("program", new Program());
        return new ModelAndView("Mentor-DisplayPrograms", modelMap);
    }
	
	
	/************************************ Program Request ***********************************************/
	
	@RequestMapping(value = "/mentorViewProgramRequests")
    public ModelAndView mentorViewProgramRequests(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorViewProgramRequests Method");
				
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();
		
		int programId = program.getProgramId();
		String programName = program.getProgramName();
		
		int noOfRequests = programRequestService.getNoOfWaitingRequestsByProgram(programId);
		
		ModelMap modelMap = new ModelMap();
		
		if(noOfRequests > 0) { // Requests are present for the program
			
			List<ProgramRequest> programRequestList = programRequestService.getAllWaitingRequestsByProgram(programId);
			
			for(ProgramRequest programRequest : programRequestList) {
				RequestDetails requestDetails = new RequestDetails();
				int menteeId = programRequest.getMenteeId();
				String menteeName = employeeService.getEmployee(menteeId).getEmployeeName();
				String manager = employeeService.getManager(menteeId);
				requestDetails.setRequestId(programRequest.getRequestId());				
				requestDetails.setProgramId(programId);
				requestDetails.setMenteeId(menteeId);
				requestDetails.setMenteeName(menteeName);
				requestDetails.setManager(manager);
				requestDetailsList.add(requestDetails);
			}
			modelMap.addAttribute("errorMsg", "");
		}
		else { 	// No requests for the program
			modelMap.addAttribute("errorMsg", "No Requests available for the program");
		}				
			
		modelMap.addAttribute("programName", programName);
		modelMap.addAttribute("requestDetailsList", requestDetailsList);
		modelMap.addAttribute("requestDetail", new RequestDetails());
        return new ModelAndView("Mentor-ProgramRequests", modelMap);
    }
	
	@RequestMapping(value = "/mentorViewRequest")
    public ModelAndView mentorViewRequest(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("requestDetail")RequestDetails requestDetail) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorViewRequest Method");
				
		int requestId = requestDetail.getRequestId();		
		int menteeId = requestDetail.getMenteeId();
		int programId = requestDetail.getProgramId();
		
		RequestDetails requestDetailsTemp = requestDetailsService.populateRequestDetails(requestId, menteeId, programId);
					
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");				
		modelMap.addAttribute("requestDetail", requestDetailsTemp);
        return new ModelAndView("Mentor-ViewRequest", modelMap);
    }
	
	@RequestMapping(value = "/mentorProcessRequest")
    public ModelAndView mentorProcessRequest(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("requestDetail")RequestDetails requestDetail) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorProcessRequest Method");
				
		int requestId = requestDetail.getRequestId();
		int menteeId = requestDetail.getMenteeId();
		int programId = requestDetail.getProgramId();			
		int availableSlots = programService.getNoOfAvailableSlots(programId);
		
		String requestStatus = requestDetail.getRequestStatus();			
		
		ModelAndView modelView;
		
		
		if(requestStatus.equalsIgnoreCase("Accepted") && availableSlots > 0) {
			
			Program program = programService.getProgram(programId);
			ProgramParticipant programParticipant = programParticipantService.populateNewParticipant(program, menteeId);
						
			programParticipantService.addProgramParticipant(programParticipant);
			programService.increamentEnrolledNo(programId);			
			programRequestService.updateRequestStatus(requestId, requestStatus);
			
			RequestDetails requestDetailAccepted = requestDetailsService.populateRequestDetails(requestId, menteeId, programId);
			requestDetailAccepted.setRequestStatus("Active");
			//modelMap.addAttribute("errorMsg", "Request Accepted");
			//Redirecting to ViewSession
			modelView = mentorViewSession(request, response, requestDetailAccepted);
		
		}
		else if(requestStatus.equalsIgnoreCase("Rejected")) {
			programRequestService.updateRequestStatus(requestId, requestStatus);					
			//modelMap.addAttribute("errorMsg", "Request Rejected");
			//Redirecting to ViewProgramRequests
			modelView = mentorViewProgramRequests(request, response, programService.getProgram(programId));
		}
		else {			
			//Redirecting to ViewProgramRequests
			modelView = mentorViewProgramRequests(request, response, programService.getProgram(programId));
			modelView.getModelMap().addAttribute("errorMsg", "No of Available Slots is exceeding. Not added");
		}			
									
        return modelView;
    }
	
	/************************************ Program Session ***********************************************/
	
	@RequestMapping(value = "/mentorViewProgramSessions")
    public ModelAndView mentorViewProgramSessions(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
				
		logger.info("Inside Mentor Controller: mentorViewProgramSessions Method");
		
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();
		
		int programId = program.getProgramId();
		String programName = program.getProgramName();
		
		int noOfSessions = programParticipantService.getNoOfActiveParticipantsByProgram(programId);
		
		ModelMap modelMap = new ModelMap();
		
		if(noOfSessions > 0) { // Program Sessions are present for the program
			
			List<ProgramParticipant> programParticipantList = 
					programParticipantService.getAllParticipantsByProgramAndStatus(programId, "Active");			
			
			
			requestDetailsList = requestDetailsService.
									getReqDetailsFromParticipants(programParticipantList, programId, "Active");					
					
			modelMap.addAttribute("errorMsg", "");
		}
		else { 	// No program sessions for the program
			modelMap.addAttribute("errorMsg", "No Sessions available for the program");
		}				
			
		modelMap.addAttribute("programName", programName);
		modelMap.addAttribute("requestDetailsList", requestDetailsList);
		modelMap.addAttribute("requestDetail", new RequestDetails());
        return new ModelAndView("Mentor-ProgramSessions", modelMap);
    }
	
	@RequestMapping(value = "/mentorViewSession")
    public ModelAndView mentorViewSession(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("requestDetail")RequestDetails requestDetail) throws IOException {  
				
		logger.info("Inside Mentor Controller: mentorViewSession Method");
		
		int menteeId = requestDetail.getMenteeId();
		int programId = requestDetail.getProgramId();	
		String sessionStatus = requestDetail.getRequestStatus();
		
		ProgramSession programSession = programSessionService.getProgramSession(menteeId, programId, sessionStatus);		
		
		ModelAndView modelView;
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");				
		modelMap.addAttribute("programSession", programSession);	
		
		if(sessionStatus.equalsIgnoreCase("Active")) {
			modelView = new ModelAndView("Mentor-ViewActiveSession", modelMap);
		}
		else {
			int noOfAvailableSlots = programService.getNoOfAvailableSlots(programId);
			modelMap.addAttribute("noOfAvailableSlots", noOfAvailableSlots);
			modelView = new ModelAndView("Mentor-ViewInActiveSession", modelMap);
		}
		
        return modelView;
    }
	
	@RequestMapping(value = "/mentorProcessSession")
    public ModelAndView mentorProcessSession(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("programSession")ProgramSession programSession) throws IOException {  
		
		logger.info("Inside Mentor Controller: mentorProcessSession Method");
		
		int participantId = programSession.getParticipantId();
		int programId = programParticipantService.getProgramParticipant(participantId).getProgramId();
		
		
		ProgramParticipant programParticipant = programParticipantService.getProgramParticipant(participantId);
		programParticipant.setCourseCompletionStatus(programSession.getCourseCompletionStatus());
		programParticipant.setMentorNotes(programSession.getMentorNotes());
		if(programSession.getCourseCompletionStatus().equalsIgnoreCase("Inprogress")) {
			
			if(programSession.getSessionStatus().equalsIgnoreCase("Inactive")) {	// From History Session
				programParticipant.setParticipationStatus("Active");
				programService.increamentEnrolledNo(programId);
			}
			else {		// From Active Session
				programParticipant.setParticipationStatus("Active");
			}
		}
		else {
			if(programSession.getSessionStatus().equalsIgnoreCase("Inactive")) { // From History Session
				programParticipant.setParticipationStatus("Inactive");
			}
			else { 	// From Active Session
				programParticipant.setParticipationStatus("Inactive");
				programService.decreamentEnrolledNo(programId);
			}
			
		}
		
		programParticipantService.updateProgramParticipant(programParticipant);
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "Session Saved Successfully");
		
		ModelAndView modelView = mentorPage(request, response);
			
       return modelView;
    }
	
	/************************************ Program History ***********************************************/
	
	@RequestMapping(value = "/mentorViewHistoySessions")
    public ModelAndView mentorViewHistoySessions(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
				
		logger.info("Inside Mentor Controller: mentorViewHistoySessions Method");
		
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();
		
		int programId = program.getProgramId();
		String programName = program.getProgramName();
		
		int noOfSessions = programParticipantService.getNoOfInactiveParticipantsByProgram(programId);
		
		ModelMap modelMap = new ModelMap();
		
		if(noOfSessions > 0) { // Program Sessions are present for the program
			
			List<ProgramParticipant> programParticipantList = 
					programParticipantService.getAllParticipantsByProgramAndStatus(programId, "Inactive");			
			
			
			requestDetailsList = requestDetailsService.
									getReqDetailsFromParticipants(programParticipantList, programId, "Inactive");					
					
			modelMap.addAttribute("errorMsg", "");
		}
		else { 	// No program sessions for the program
			modelMap.addAttribute("errorMsg", "No Closed Sessions available for the program");
		}				
			
		modelMap.addAttribute("programName", programName);
		modelMap.addAttribute("requestDetailsList", requestDetailsList);
		modelMap.addAttribute("requestDetail", new RequestDetails());
        return new ModelAndView("Mentor-ProgramSessions", modelMap);
    }
	
	/********************************** Redirection ****************************************/
	
	
	
}
