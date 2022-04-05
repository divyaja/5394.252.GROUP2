package com.prj.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prj.cas.service.ProfService;

@RestController
public class ProfessorController {
	
	@Autowired
	private ProfService profService;

}
