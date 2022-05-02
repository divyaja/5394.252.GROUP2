package com.prj.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prj.cms.entity.Course;
import com.prj.cms.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@GetMapping("/courses")
	public String listCourses(Model model) {
		model.addAttribute("courses", courseService.getAllCourses());
		return "courses";
	}

	@GetMapping("/courses/new")
	public String createNewCourse(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "create_course";
	}

	@PostMapping("/courses")
	public String saveCourse(@ModelAttribute("course") Course course, BindingResult result) {

		Course existing = courseService.findByName(course.getCourseName());
//		System.out.println("existing course data" + existing.toString());
		if (existing != null) {
			result.rejectValue("courseName", null, "The course already exists.");
		}

		if (result.hasErrors()) {
			return "create_course";
		}
		courseService.saveCourse(course);
		return "redirect:/courses";
	}

	@GetMapping("/courses/edit/{id}")
	public String editCourseForm(@PathVariable int id, Model model) {
		model.addAttribute("course", courseService.getCourseById(id));
		return "edit_course";
	}

	@PostMapping("/courses/{id}")
	public String updateCourse(@PathVariable int id, @ModelAttribute("course") Course course, Model model) {

		Course existingCourse = courseService.getCourseById(id);
		existingCourse.setId(id);
		existingCourse.setCourseName(course.getCourseName());

		courseService.updateCourse(existingCourse);
		return "redirect:/courses";
	}

	// GetMapping
	@GetMapping("/courses/{id}")
	public String deleteCourse(@PathVariable int id) {
		courseService.deleteCourseById(id);
		return "redirect:/courses";
	}

}
