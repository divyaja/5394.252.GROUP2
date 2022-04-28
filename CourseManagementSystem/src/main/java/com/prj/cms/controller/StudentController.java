package com.prj.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prj.cms.entity.Course;
import com.prj.cms.entity.StudentCourses;
import com.prj.cms.service.AssignmentService;
import com.prj.cms.service.StudentCourseService;

import com.prj.cms.service.StudentService;
import com.prj.cms.service.impl.UserDetailsImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentCourseService studentCourseService;

	@Autowired
	private AssignmentService assignmentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	List<Course> courses;

	/*
	 * @ModelAttribute public void loadAllCourses(Model model) { courses = new
	 * ArrayList<>(); courses.addAll(studentService.getAllCourses()); }
	 */

	@GetMapping("/listStudentCourses")

	public String listStudentCourses(Model model) {

		// System.out.println("size of the courses in the Db : " +
		// studentService.getAllCourses().size());

		model.addAttribute("studentAssignments", assignmentService.getAllAssignments());
		return "studentPage";
	}

	@GetMapping("/listStudentAssignments")
	public String listStudentAssignments(Model model) {

		System.out.println("size of the assignments in the Db : " + assignmentService.getAllAssignments());
		model.addAttribute("studentAssignments", assignmentService.getAllAssignments());
		return "studentPage";// return to assignments page
	}

	@GetMapping("/studentDashboard")
	public String dashboard(Model model) {
		List<StudentCourses> studentCoursesMapping = studentCourseService.findAllCourseStudentMappings();
		List<Course> coursesRegistered = studentService.getAllCourses().stream()
				.filter(f -> studentCoursesMapping.stream().anyMatch(s -> f.getId() == s.getCourseId()))
				.collect(Collectors.toList());

		coursesRegistered.stream().forEach(s -> System.out.println(s.toString()));
		model.addAttribute("studentCourses", coursesRegistered);
	@GetMapping("/studentDashboard")
	public String register(Model model) {
		return "studentDashboardPage";
	}

	@PostMapping("/registerStudentCourse")
	public String registerStudentCourse(@ModelAttribute("course") Course course, BindingResult result) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		System.out.println("Course Details from htmlpage : " + course.getCourseName() + "ID : " + course.getId());

		System.out.println("STudent Details : " + userDetails.getID());
		System.out.println("STudent Details : " + userDetails.getUsername());
		System.out.println("STudent Details : " + userDetails.getType());

		StudentCourses objStudentCourse = new StudentCourses(course.getId(), userDetails.getID());
//		studentCourseService.saveStudentCourse(objStudentCourse);
		List<StudentCourses> existingData = studentCourseService.findAllCourseStudentMappings();
		if (isRegistered(existingData, objStudentCourse)) {
			result.rejectValue("courseName", null, "Duplicate request. Please register a new course.");
		}

		studentCourseService.saveStudentCourse(objStudentCourse);

		/*
		 * Course existing = studentService.findByName(course.getCourseName()); if
		 * (existing != null) { List<User> existingStudents = (List<User>)
		 * existing.getStudents(); boolean isRegistered =
		 * checkIfStudentisRegistered(existingStudents, userDetails.getUsername());
		 * 
		 * if (isRegistered) { result.rejectValue("courseName", null,
		 * "Duplicate request. Please register a new course."); } }
		 * 
		 * Course courseObj = new Course(); List<User> studentsEmail = new
		 * ArrayList<>(); User userobj = new User();
		 * userobj.setEmail(userDetails.getUsername());
		 * userobj.setId(userDetails.getID());
		 * 
		 * studentsEmail.add(userobj);
		 * 
		 * courseObj.setCourseName(course.getCourseName());
		 * courseObj.setId(course.getId()); courseObj.setStudents(studentsEmail);
		 */

		// studentService.saveCourse(course);
		/// if student is already registered to the course
		/*
		 * if ((existing != null && existing.getStudents() != null) &&
		 * existing.getStudentEmailID() == course.getStudentEmailID()) { } if
		 * (result.hasErrors()) { return "create_course"; }
		 * studentService.saveCourse(course);
		 */

	public String saveCourse(@ModelAttribute("course") Course course, BindingResult result) {

		Course existing = studentService.findByName(course.getCourseName());
		System.out.println("Existing Course ID : " + existing.getStudentID());

		if ((existing != null && existing.getStudentID() > 0) && existing.getStudentID() == course.getStudentID()) {
			result.rejectValue("courseName", null, "Duplicate request. Please register a new course.");
		}
		if (result.hasErrors()) {
			return "create_course";
		}
		studentService.saveCourse(course);
		return "redirect:/listStudentCourses";
	}
	/*
	 * @PostMapping("/registerStudentCourses") public String
	 * saveStudentCourse(@ModelAttribute("course") Course course, BindingResult
	 * result) {
	 * 
	 * Course existing = courseService.findByName(course.getCourseName()); //
	 * System.out.println("existing course data" + existing.toString()); if
	 * (existing != null) { result.rejectValue("courseName", null,
	 * "The course already exists."); }
	 * 
	 * if (result.hasErrors()) { return "create_course"; }
	 * courseService.saveCourse(course); return "redirect:/courses"; }
	 */

	private boolean isRegistered(List<StudentCourses> existingData, StudentCourses objStudentCourse) {
		if (existingData != null && !existingData.isEmpty() && objStudentCourse != null) {
			for (StudentCourses sc : existingData) {
				if (sc.getCourseId() == objStudentCourse.getCourseId()
						&& sc.getStudentId() == objStudentCourse.getStudentId()) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * private boolean checkIfStudentisRegistered(List<User> existingStudents,
	 * String studentEmail) { if (existingStudents != null &&
	 * !existingStudents.isEmpty()) for (User student : existingStudents) { if
	 * (student.getEmail().equalsIgnoreCase(studentEmail)) { return true; } } return
	 * false; }
	 */

	@GetMapping("/studentCourses/{id}")
	public String deleteCourse(@PathVariable int id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		System.out.println("course id in student controller : " + id);
		StudentCourses studentCourse = new StudentCourses(id, userDetails.getID());
		studentCourseService.deleteStudentCourse(studentCourse);
		return "redirect:/studentDashboard";
	}
}
