package com.prj.cms.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prj.cms.entity.Enum.TYPE;
import com.prj.cms.service.impl.UserDetailsImpl;

@Controller
public class MainController {

	@GetMapping("/")
	public String root() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		System.out.println("TYPE OF LOGGED IN USER:  " + userDetails.getType().toString());
		if (userDetails.getType().equals(TYPE.ADMIN.toString())) {
			return "adminRegistration";
		} else if (userDetails.getType().equals(TYPE.STUDENT.toString())) {
			return "StudentDashboardPage.html";
		} else if (userDetails.getType().equals(TYPE.PROFESSOR.toString())) {
			return "professorDashboard";
		}

		return "adminRegistration";

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
