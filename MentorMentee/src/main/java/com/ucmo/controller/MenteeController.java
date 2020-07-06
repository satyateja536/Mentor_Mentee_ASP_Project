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

import com.ucmo.dto.MenteeProgramSession;
import com.ucmo.dto.MenteeRequestDetails;
import com.ucmo.dto.MenteeRequestInputs;
import com.ucmo.dto.Program;
import com.ucmo.dto.ProgramParticipant;
import com.ucmo.dto.ProgramRequest;
import com.ucmo.dto.User;
import com.ucmo.service.CourseService;
import com.ucmo.service.EmployeeService;
import com.ucmo.service.MenteeProgramSessionService;
import com.ucmo.service.MenteeRequestDetailsService;
import com.ucmo.service.MenteeRequestInputsService;
import com.ucmo.service.ProgramParticipantService;
import com.ucmo.service.ProgramRequestService;
import com.ucmo.service.ProgramService;
import com.ucmo.service.UserService;

@Controller
public class MenteeController {
	
	private static final Logger logger = Logger.getLogger(MentorController.class);
	
	public MenteeController() {
        logger.info("Mentee-Controller()");
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
	private MenteeRequestDetailsService menteeRequestDetailsService;
	
	@Autowired
	private MenteeProgramSessionService menteeProgramSessionService;
	
	@Autowired
	private MenteeRequestInputsService menteeRequestInputsService;
	

	/************************* Mentor Home Page **************************/
	
	@RequestMapping(value = "/menteePage")
    public ModelAndView menteePage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteePage Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int menteeId = userService.getUser(username).get(0).getEmployeeId();
		
		User mentee = userService.getUser(username).get(0);	
		
		
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");
		
		/**************************** Home Page Program *************************************/
		
		modelMap.addAttribute("program", new Program());
       
		
		/**************************** Home Page Request *************************************/
		
		  List<ProgramRequest> requestList =
		  programRequestService.getWaitingMenteeRequests(menteeId);
		  
		  List<MenteeRequestInputs> menteeRequestInputsList = new ArrayList<MenteeRequestInputs>();
		  
		  if(!requestList.isEmpty()) {
			  menteeRequestInputsList = menteeRequestInputsService.getMenteeRequestInputsByRequests(requestList);
		  }		  
		  
		  modelMap.addAttribute("menteeRequestInputsList", menteeRequestInputsList);
		  modelMap.addAttribute("menteeRequestInput", new MenteeRequestInputs());
		 
		
		/**************************** Home Page Session *************************************/		
		  
		  List<ProgramParticipant> menteeSessionsLits = 
				  programParticipantService.getAllParticipantsByMenteeAndStatus(menteeId, "Active");
		  
		  List<MenteeRequestInputs> sessionInputsList = 
				  menteeRequestInputsService.getMenteeRequestInputsByParticipants(menteeSessionsLits);
		  
		  modelMap.addAttribute("sessionInputsList", sessionInputsList);
		  modelMap.addAttribute("programParticipant", new ProgramParticipant());
		  
		/**************************** Home Page History *************************************/
		
		ModelAndView modelView;
		
		if(mentee.getMenteeStatus().equalsIgnoreCase("Inactive")) {
			modelMap.addAttribute("user", mentee);
			modelView = new ModelAndView("Mentee-ActivationPage", modelMap);
		}
		else {
			modelView = new ModelAndView("Mentee-Home", modelMap);
		}
		
        return modelView;
    }
	
	@RequestMapping(value = "/menteeStatusChangeToActive")
    public ModelAndView menteeStatusChangeToActive(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("user")User user) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeActivationStatus Method");
		
		User userReq = userService.getUser(user.getUsername()).get(0);
		
		userReq.setMenteeStatus("Active");
		
		userService.updateUser(userReq);
		
		ModelAndView modelView;
		modelView = menteePage(request, response);	
			
        return modelView;
    }
	
	/***************************************** Program **********************************************/
	
	@RequestMapping(value = "/menteeGetProgramPage")
    public ModelAndView menteeGetProgramPage(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeGetProgramPage Method");
		
		List<String> programNames = programService.getDistinctProgramNamesByStatus("Active");
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("programNames", programNames);	
		modelMap.addAttribute("program", new Program());
        return new ModelAndView("Mentee-GetProgramDetails", modelMap);
    }
	
	@RequestMapping(value = "/menteeGetProgram")
    public ModelAndView menteeGetProgram(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeGetProgram Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int menteeId = userService.getUser(username).get(0).getEmployeeId();
		
		List<Program> programsList;
		programsList = programService.getProgramsWithSlots(program.getProgramName(), "Active");
		
		List<MenteeRequestInputs> menteeInputList;
		menteeInputList = menteeRequestInputsService.getMenteeRequestInputsByPrograms(programsList, menteeId);
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("menteeInputList", menteeInputList);	
		modelMap.addAttribute("program", new Program());
        return new ModelAndView("Mentee-DisplayPrograms", modelMap);
    }
	
	@RequestMapping(value = "/menteeViewProgram")
    public ModelAndView menteeViewProgram(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("program")Program program) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeViewProgram Method");
		
		Program programSelected = programService.getProgram(program.getProgramId());
		
		int courseId = programSelected.getCourseId();
		int mentorId = programSelected.getMentorId();
		
		String courseGroup = courseService.getCourse(courseId).getCourseGroup();
		String mentorName = employeeService.getEmployee(mentorId).getEmployeeName();
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("program", programSelected);
		modelMap.addAttribute("courseGroup", courseGroup);
		modelMap.addAttribute("mentorName", mentorName);
		modelMap.addAttribute("programRequest", new ProgramRequest());
        return new ModelAndView("Mentee-ViewProgram", modelMap);
    }
	
	@RequestMapping(value = "/menteeJoinProgram")
    public ModelAndView menteeJoinProgram(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("programRequest")ProgramRequest programRequest) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeJoinProgram Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int menteeId = userService.getUser(username).get(0).getEmployeeId();
		int programId = programRequest.getProgramId();
		Program program = programService.getProgram(programId);
		String programName = program.getProgramName();
		int mentorId = program.getMentorId();
		String mentorName = employeeService.getEmployee(mentorId).getEmployeeName();
		String menteeComments = programRequest.getMenteeComments();
		
		ProgramRequest newRequest = programRequestService
				.populateProgramRequest(menteeId, programId, menteeComments, "Waiting");
		
		String status = programRequestService.requestValidation(menteeId, programId);		
		
		ModelAndView modelView;
		String errorMsg;
		
		if(status.equalsIgnoreCase("Valid")) { 
			// Add Request to Table
			programRequestService.addProgramRequest(newRequest);
			modelView = menteePage(request, response);
		}
		else {
			if(status.equalsIgnoreCase("Waiting")) {
				errorMsg = "Pending Request already exists for program: "+programName+" and Mentor: "+mentorName;
			}
			else if(status.equalsIgnoreCase("Accepted")){
				errorMsg = "Active Session already exists for program: "+programName+" and Mentor: "+mentorName;
			}
			else {
				errorMsg = "Maximum No of Attempts Reached for program: "+programName+" and Mentor: "+mentorName;
			}
			
			modelView = menteeGetProgram(request, response, program);
			modelView.getModelMap().addAttribute("errorMsg", errorMsg);
			
			//Same Model View
		}							
		
        return modelView;
    }
	
	
	
	
	/************************************ Program Request ***********************************************/
	
	@RequestMapping(value = "/menteeViewAllProgramRequests")
    public ModelAndView menteeViewAllProgramRequests(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("menteeRequestInput")MenteeRequestInputs menteeRequestInput) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeViewAllProgramRequests Method");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int menteeId = userService.getUser(username).get(0).getEmployeeId();
		
		List<ProgramRequest> requestList =
				  programRequestService.getNonWaitingMenteeRequests(menteeId);
				  
		List<MenteeRequestInputs> menteeRequestInputsList = new ArrayList<MenteeRequestInputs>();
				  
		if(!requestList.isEmpty()) {
			menteeRequestInputsList = menteeRequestInputsService.getMenteeRequestInputsByRequests(requestList);
	    }					
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("menteeRequestInputsList", menteeRequestInputsList);
		modelMap.addAttribute("menteeRequestInput", new MenteeRequestInputs());
        return new ModelAndView("Mentee-ProgramRequests", modelMap);
    }
	
	
	
	@RequestMapping(value = "/menteeViewProgramRequest")
    public ModelAndView menteeViewProgramRequest(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("menteeRequestInput")MenteeRequestInputs menteeRequestInput) throws IOException {  
			
		logger.info("Inside Mentee Controller: menteeViewProgramRequest Method");
		
		int requestId = menteeRequestInput.getRequestId();		
		
		MenteeRequestDetails menteeRequestDetails = menteeRequestDetailsService.populateRequestDetails(requestId);
				
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");			
		modelMap.addAttribute("menteeRequestDetails", menteeRequestDetails);
        return new ModelAndView("Mentee-ViewProgramRequest", modelMap);
    }
	
	
	
	
	/************************************ Program Session ***********************************************/
	
	@RequestMapping(value = "/menteeViewSession")
    public ModelAndView menteeViewSession(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("programParticipant")ProgramParticipant programParticipant) throws IOException {  
				
		logger.info("Inside Mentee Controller: menteeViewSession Method");
		
		int participantId = programParticipant.getParticipantId();
				
		ProgramParticipant participant = programParticipantService.getProgramParticipant(participantId);
		
		String sessionStatus = participant.getParticipationStatus();
		
		MenteeProgramSession menteeProgramSession = menteeProgramSessionService.getMenteeProgramSession(participantId);
		
		
		ModelAndView modelView;
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errorMsg", "");				
		modelMap.addAttribute("menteeProgramSession", menteeProgramSession);	
		
		if(sessionStatus.equalsIgnoreCase("Active")) {
			modelView = new ModelAndView("Mentee-ViewActiveSession", modelMap);
		}
		else {			
			modelView = new ModelAndView("Mentee-ViewInActiveSession", modelMap);
		}
		
        return modelView;
    }
	
	@RequestMapping(value = "/menteeProcessSession")
    public ModelAndView menteeProcessSession(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("menteeProgramSession")MenteeProgramSession menteeProgramSession) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeProcessSession Method");
		
		int participantId = menteeProgramSession.getParticipantId();
		ProgramParticipant participant = programParticipantService.getProgramParticipant(participantId);
		
		participant.setMenteeNotes(menteeProgramSession.getMenteeNotes());		
	
		
		programParticipantService.updateProgramParticipant(participant);
				
		
		ModelAndView modelView = menteePage(request, response);
		modelView.getModelMap().addAttribute("errorMsg", "Session Saved Successfully");
			
			
       return modelView;
    }
	
	
	/************************************ Program History ***********************************************/
	
	@RequestMapping(value = "/menteeViewHistorySessions")
    public ModelAndView menteeViewHistorySessions(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("programParticipant")ProgramParticipant programParticipant) throws IOException {  
		
		logger.info("Inside Mentee Controller: menteeViewHistorySessions Method");		
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("user");
		int menteeId = userService.getUser(username).get(0).getEmployeeId();
		
		List<ProgramParticipant> menteeSessionsLits = 
				  programParticipantService.getAllParticipantsByMenteeAndStatus(menteeId, "Inactive");
		  
		List<MenteeRequestInputs> sessionInputsList = 
				  menteeRequestInputsService.getMenteeRequestInputsByParticipants(menteeSessionsLits);
		 
		ModelMap modelMap = new ModelMap();
		
		if(sessionInputsList.isEmpty()) {
			modelMap.addAttribute("errorMsg", "No Inactive Sessions");
		}		
		
		modelMap.addAttribute("sessionInputsList", sessionInputsList);
		modelMap.addAttribute("programParticipant", new ProgramParticipant());		
        return new ModelAndView("Mentee-HistoryProgramSessions", modelMap);
    }
	
}
