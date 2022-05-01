package com.prj.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prj.cms.controller.dto.UserRegistrationDto;
import com.prj.cms.entity.User;
import com.prj.cms.service.UserService;
import com.prj.cms.service.impl.UserDetailsImpl;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	List<String> types;

	@ModelAttribute
	public void preLoad(Model model) {
		types = new ArrayList<>();
		types.add("Professor");
		types.add("Student");
		types.add("Admin");
		
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("userRoles", types);
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
			BindingResult result) {

		User existing = userService.findByEmail(userDto.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			return "registration";
		}

		userService.save(userDto);
//		return "redirect:/login";
		return "redirect:/user";
	}

	@GetMapping("/user")
	public String currentUser(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result,
			Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		User user = userService.findByEmail(userDetails.getUsername());
		String firstname = user.getFirstName();
		model.addAttribute("firstName", firstname);
		model.addAttribute("emailAddress", user.getEmail());

		return "UserDetailsPage"; // this is the name of my template
	}

}
