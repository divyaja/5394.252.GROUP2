package com.prj.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prj.cas.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

}
