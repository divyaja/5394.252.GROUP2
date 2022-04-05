package com.prj.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prj.cas.pojo.request.AdminRequest;
import com.prj.cas.pojo.response.AdminReponse;
import com.prj.cas.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;


	@PostMapping(value="/user")
	public AdminReponse createUser(@RequestBody AdminRequest adminRequest) {
		return new AdminReponse();
	}

}
