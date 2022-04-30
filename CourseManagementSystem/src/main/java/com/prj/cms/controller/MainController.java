package com.prj.cms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prj.cms.entity.Course;
import com.prj.cms.entity.ProfessorCourses;
import com.prj.cms.entity.StudentCourses;
import com.prj.cms.entity.Enum.TYPE;
import com.prj.cms.service.CourseService;
import com.prj.cms.service.ProfessorServive;
import com.prj.cms.service.StudentCourseService;
import com.prj.cms.service.impl.UserDetailsImpl;

@Controller
public class MainController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentCourseService studentCourseService;
	@Autowired
	private ProfessorServive professorCourseService;

	@GetMapping("/")
	public String root(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		System.out.println("TYPE OF LOGGED IN USER:  " + userDetails.getType().toString());
		if (userDetails.getType().equals(TYPE.ADMIN.toString())) {
			return "adminRegistration";
		} else if (userDetails.getType().equals(TYPE.STUDENT.toString())) {

			return studentDashboard(userDetails, model);

		} else if (userDetails.getType().equals(TYPE.PROFESSOR.toString())) {
			return professorDashboard(userDetails, model);
		}

		return "adminRegistration";

	}

	private String professorDashboard(UserDetailsImpl userDetails, Model model) {
		List<ProfessorCourses> professorCoursesMapping = professorCourseService.findAllCourseProfessorMappings();
		List<ProfessorCourses> filteredProfessorCoursesMapping = professorCoursesMapping.stream()
				.filter(s -> s.getProfessorId() == userDetails.getID()).collect(Collectors.toList());
		List<Course> coursesRegistered = courseService.getAllCourses().stream()
				.filter(f -> filteredProfessorCoursesMapping.stream().anyMatch(s -> f.getId() == s.getCourseId()))
				.collect(Collectors.toList());
		coursesRegistered.stream().forEach(s -> System.out.println(s.toString()));
		model.addAttribute("professorCourseMappings", coursesRegistered);
		return "professorDashboardPage";
	}

	private String studentDashboard(UserDetailsImpl userDetails, Model model) {

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

	@GetMapping("/register")
	public String register(Model model) {
		return "registration";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/UserDetailsPage")
	public String UserDetailsPage(Model model) {
		return "UserDetailsPage";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "/courses";
	}

}
