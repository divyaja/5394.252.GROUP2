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
import com.prj.cms.entity.ProfessorCourses;
import com.prj.cms.service.AssignmentService;
import com.prj.cms.service.CourseAssignmentService;
import com.prj.cms.service.CourseService;
import com.prj.cms.service.ProfessorServive;
import com.prj.cms.service.impl.UserDetailsImpl;

@Controller
public class ProfessorController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private ProfessorServive professorCourseService;

	@Autowired
	private CourseAssignmentService courseAssignmentService;

	@Autowired
	private AssignmentService assignmentService;

	@GetMapping("/listProfessorCourses")
	public String listProfessorCourses(Model model) {
		model.addAttribute("professorCourses", courseService.getAllCourses());
		return "professorPage";
	}

	@GetMapping("/assignmentDashboard/{courseId}")
	public String loadAssignments(Model model, Integer courseId) {
		List<CourseAssignments> courseAssignments = courseAssignmentService.getAllAssignments();
		List<CourseAssignments> finalCourseAssignments = courseAssignments.stream()
				.filter(s -> s.getCourseId() == courseId).collect(Collectors.toList());
		System.out.println("size of all assignments created in DB : " + courseAssignments.size());
		System.out.println(
				"size of courses mappings assignments created in DB : " + assignmentService.getAllAssignments().size());

		List<Assignment> assignmentsRegistered = assignmentService.getAllAssignments().stream()
				.filter(f -> finalCourseAssignments.stream().anyMatch(s -> f.getId() == s.getAssignmentId()))
				.collect(Collectors.toList());
		assignmentsRegistered.stream().forEach(s -> System.out.println(s.toString()));
		model.addAttribute("assignmentslist", assignmentsRegistered);
		System.out.println("course id in load assignments page" + courseId);
		model.addAttribute("courseID", courseId);
		return "AssignmentsHomePage";
	}

	@GetMapping("/professorDashboard")
	public String professorDashboard(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

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

	@PostMapping("/registerProfessorCourse")
	public String registerProfessorCourse(Model model, @ModelAttribute("course") Course course, BindingResult result) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		ProfessorCourses obj = new ProfessorCourses(course.getId(), userDetails.getID());
		List<ProfessorCourses> existingData = professorCourseService.findAllCourseProfessorMappings();
		if (isRegistered(existingData, obj)) {
			result.rejectValue("id", null, "Duplicate request. Please register a new course.");
//			System.out.println("Duplicate course Request");
		} else {

			professorCourseService.saveProfessorCourse(obj);
		}
		return professorDashboard(model);
	}

	private boolean isRegistered(List<ProfessorCourses> existingData, ProfessorCourses objProfessorCourses) {
		if (existingData != null && !existingData.isEmpty() && objProfessorCourses != null) {
			for (ProfessorCourses pc : existingData) {
				if (pc.getCourseId() == objProfessorCourses.getCourseId()
						&& pc.getProfessorId() == objProfessorCourses.getProfessorId()) {
					return true;
				}
			}
		}
		return false;
	}

	@GetMapping("addAssignmentForCourse/{courseId}")
	public String addAssignmentForCourse(Model model, @PathVariable int courseId) {
		model.addAttribute("courseID", courseId);
		Assignment assignment = new Assignment();
		model.addAttribute("assignment", assignment);
		return "create_assignment";
	}

	@PostMapping("/saveAssignment/{courseId}")
	public String addAssignment(@ModelAttribute("assignment") Assignment assignment, Model model,
			@PathVariable int courseId, BindingResult result) {

		List<Assignment> list = assignmentService.getAllAssignments();
		assignment.setId(list.size() + 1);
		Assignment assObj = new Assignment(assignment.getId(), courseId, assignment.getAssignmentName(),
				assignment.getAssignmentDescription(), assignment.getDueDate());
		assignmentService.saveAssignment(assObj);
		CourseAssignments ca = new CourseAssignments(courseId, assignment.getId());
		courseAssignmentService.saveCourseAssignment(ca);
		System.out.println("course ID in save assignment page " + courseId);
		return loadAssignments(model, courseId);
	}

	@GetMapping("/professorCourses/add/assignments/{id}")
	public String addCourseAssignments(@PathVariable int id, Model model) {
		model.addAttribute("courseID", id);
		Assignment assObj = new Assignment();
		model.addAttribute("assignment", assObj);
//		return "create_assignment";
		return loadAssignments(model, id);
	}

	@GetMapping("/professorCourses/{id}")
	public String deleteProfessorCourseMapping(@PathVariable int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		ProfessorCourses professorCourse = new ProfessorCourses(id, userDetails.getID());
		professorCourseService.deleteProfessorCourseMapping(professorCourse);

		return "redirect:/professorDashboard";
	}

	@GetMapping("/assignments/{assignmentId}/{courseId}")
	public String deleteCourseAssignmentMapping(@PathVariable int assignmentId, @PathVariable int courseId,
			Model model) {
		CourseAssignments courseAssObj = new CourseAssignments(courseId, assignmentId);
		courseAssignmentService.deleteCourseAssignment(courseAssObj);
		assignmentService.deleteAssignmentById(assignmentId);
		model.addAttribute("courseID", courseId);
		return loadAssignments(model, courseId);

	}

}
