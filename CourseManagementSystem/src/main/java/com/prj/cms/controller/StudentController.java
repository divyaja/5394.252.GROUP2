package com.prj.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prj.cms.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;

	}

	@GetMapping("/listStudentCourses")
	public String listStudentCourses(Model model) {
		System.out.println("size of the courses in the Db : " + studentService.getAllCourses().size());
		model.addAttribute("studentCourses", studentService.getAllCourses());
		return "studentPage";
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
