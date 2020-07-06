# Mentor_Mentee_ASP_Project
Project is based on Mentor-Mentee Program where a mentor(Employee) can guide a mentee(Employee) in improving a particular skill.

About Project:

Mentor-Mentee Web Application:

Abstract:
Skill enhancing plays major key role in any organization. Especially in Corporate world, it will be very difficult to pull in skill set from different corners when need arise. This paper demonstrates the program that helps the organization as well employees to enhance and utilize the skill set effectively.
 Introduction:
This project is about providing mentoring programs in an organization, to help the employees to learn and improve their skills with the help of experts (in that skill) in the organization. This is completely related to the self-interest of employees in developing their skills and helping others in developing their skills. All the effort used for this program is not included in the organization working hours of employee. 
There are three major roles in this system which are active all the time without any restrictions. 
1.	Mentor: Mentor shares information with mentee about the skill and provides guidance in helping the mentee improve the skill.
2.	Mentee: Mentee gets the information and support from the mentor in developing his skill in the required area and at some point, mentor can directly involve mentee’s assignments.
3.	Admin: Administrator manages the information related to courses, employee etc.,

Functionalities:
Role wise functionalities are given below:
	Mentor: 
o	Enroll for a course as Mentor.
o	Accept or Reject input requests from mentee based on time and availability.
o	Assist the mentees.
o	Close the session once a full cycle is done for mentee.
	Mentee: 
o	Request for assistance based on course and mentor availability.
o	Course completions as per the mentor guidelines.
o	Close the session
	Admin:
o	Add/Delete course based on the skill demand in the organization.
o	Delete employee from the system after his tenure with the organization.
o	Managing access permissions over the program (mentor – mentee ongoing program).

 
Process Flow:
1. Employees need to login to the application using their organization credentials. 
2. Once logged in Employee is presented with below pages.
	a. If he is the first-time user, he will be asked to register as either a Mentor or Mentee or both.
b. If he is already registered either as mentor or mentee, he will be presented with the respective dashboard.
3. Mentor Dashboard: 
a. New Requests: The program requests that are sent by mentees for the courses provided by the mentor. Mentor can go through mentees profile before accepting the program request.
b. History: The past programs that are provided by the mentor can be viewed by him using this functionality.
c. Ongoing Mentorship: The programs that are currently in ongoing state are shown in this functionality. Any modifications or any functionalities on the program can be done from here.
	d. Mentorship Categories:	
4. Mentee Dashboard: 
a. Requested Sessions: The Requests that are sent by mentee to various mentors for various programs. The status of these requests can be monitored here.		
b. History: The past programs that are taken by the mentee can be viewed by him using this functionality. 
c. Ongoing Mentorship: The programs that are currently in ongoing state are shown in this functionality. Any modifications or any functionalities on the program can be done from here.
d. Request a New Session: Mentee can raise a new program request by searching the course and selecting the mentor from the available mentors from the course from this functionality.	
5. Administrator: HR resources are assigned the role of administrators for this application. Below are the functionalities of the administrator:
a. Authorizing the Program requests: The Request sent by the mentee is first sent to Admin for Verification. The Admin forwards the request to mentor or rejects it based on the feedback from mentee's manager.
	b. Adding/Deleting courses to the available programs is done by Admin.	
c. After a mentor or mentee leave the organization, the adding or deleting of that employee from the organization is done by the admin.

 

Example Flow:
	Employee can be either mentor or mentee or both.
 	Ex: Emp1 can be mentor for Spring Framework.
	      	      Emp2 can be mentee for Spring Framework and mentor for Core Java.	 
	Duration of the program is limited say 2 or 3 months depending on the program mentor and mentee agrees upon.
Ex: 
Mentor 1 is having a bandwidth of 2 months and Mentee 1 is ready to take the                         program.
Mentor 2 is having a bandwidth of 3 months and Mentee wants to complete the program in 2 months. Mentee can discuss the same with mentor and proceed further.

Technologies to be used:
•	Backend - Spring MVC
•	Database - MySQL
•	UI - JSP, JavaScript, JQuery
•	Server - Apache Tomcat
•	Others - Maven
