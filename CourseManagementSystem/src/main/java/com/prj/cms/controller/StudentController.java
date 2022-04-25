package com.prj.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prj.cms.entity.Course;
import com.prj.cms.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

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
		System.out.println("size of the courses in the Db : " + studentService.getAllCourses().size());
		model.addAttribute("studentCourses", studentService.getAllCourses());
		return "studentPage";
	}

	@GetMapping("/studentDashboard")
	public String register(Model model) {
		return "studentDashboardPage";
	}

	@PostMapping("/registerStudentCourse")
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
}
