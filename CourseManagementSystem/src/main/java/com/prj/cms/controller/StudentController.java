package com.prj.cms.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.prj.cms.entity.Assignment;
import com.prj.cms.entity.Course;
import com.prj.cms.entity.CourseAssignments;
import com.prj.cms.entity.StudentCourses;
import com.prj.cms.service.AssignmentService;
import com.prj.cms.service.CourseAssignmentService;
import com.prj.cms.service.CourseService;
import com.prj.cms.service.StudentCourseService;
import com.prj.cms.service.impl.UserDetailsImpl;

@Controller
public class StudentController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentCourseService studentCourseService;

	@Autowired
	private CourseAssignmentService courseAssignmentService;

	@Autowired
	private AssignmentService assignmentService;

	public StudentController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@GetMapping("/listStudentCourses")
	public String listStudentCourses(Model model) {
		model.addAttribute("studentCourses", courseService.getAllCourses());
		return "studentPage";
	}

	@GetMapping("studentCourses/view/assignments/{courseId}")
	public String listStudentAssignments(Model model, @PathVariable int courseId) {

//		System.out.println("View Assignments course ID" + courseId);
		List<CourseAssignments> courseAssignments = courseAssignmentService.getAllAssignments();
		List<CourseAssignments> finalCourseAssignments = courseAssignments.stream()
				.filter(s -> s.getCourseId() == courseId).collect(Collectors.toList());
		List<Assignment> assignmentsRegistered = assignmentService.getAllAssignments().stream()
				.filter(f -> finalCourseAssignments.stream().anyMatch(s -> f.getId() == s.getAssignmentId()))
				.collect(Collectors.toList());
		assignmentsRegistered.stream().forEach(s -> System.out.println(s.toString()));
		model.addAttribute("assignmentslist", assignmentsRegistered);
		return "studentAssignmentsPage";

	}

	@GetMapping("/studentDashboard")
	public String dashboard(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<StudentCourses> studentCoursesMapping = studentCourseService.findAllCourseStudentMappings();
		List<StudentCourses> filteredStudentCoursesMapping = studentCoursesMapping.stream()
				.filter(s -> s.getStudentId() == userDetails.getID()).collect(Collectors.toList());
		List<Course> coursesRegistered = courseService.getAllCourses().stream()
				.filter(f -> filteredStudentCoursesMapping.stream().anyMatch(s -> f.getId() == s.getCourseId()))
				.collect(Collectors.toList());
		coursesRegistered.stream().forEach(s -> System.out.println(s.toString()));

		model.addAttribute("studentCourses", coursesRegistered);
		return "studentDashboardPage";
	}

	@PostMapping("/registerStudentCourses")
	public String registerStudentCourse(Model model, @ModelAttribute("course") Course course, BindingResult result) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		System.out.println("STudent Details : " + userDetails.getID());
		System.out.println("STudent Details : " + userDetails.getUsername());
		System.out.println("STudent Details : " + userDetails.getType());

		StudentCourses objStudentCourse = new StudentCourses(course.getId(), userDetails.getID());
		List<StudentCourses> existingData = studentCourseService.findAllCourseStudentMappings();
		if (isRegistered(existingData, objStudentCourse)) {
			result.rejectValue("courseName", null, "Duplicate request. Please register a new course.");
		}
		studentCourseService.saveStudentCourse(objStudentCourse);
		return dashboard(model);
	}

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

	@GetMapping("/studentCourses/{id}")
	public String deleteStudentCourseMapping(@PathVariable int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		System.out.println("course id in student controller : " + id);
		StudentCourses studentCourse = new StudentCourses(id, userDetails.getID());
		studentCourseService.deleteStudentCourse(studentCourse);
		return "redirect:/studentDashboard";
	}

}
