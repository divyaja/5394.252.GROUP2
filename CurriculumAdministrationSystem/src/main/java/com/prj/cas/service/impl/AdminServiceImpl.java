package com.prj.cas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cas.dao.AdminDao;
import com.prj.cas.entity.User;
import com.prj.cas.pojo.request.AdminRequest;
import com.prj.cas.pojo.response.AdminReponse;
import com.prj.cas.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public AdminReponse createUser(AdminRequest adminRequest) {

		// call dao and save the details from the adminrequest and fetch the existing
		// user entity

		// using the id, set email, username, password, then update the existing user
		// row
		// fetch username, password and email id and set it in response object
		User user = new User();
		user.setFirstName(adminRequest.getFirstName());
		user.setMiddleName(adminRequest.getMiddleName());
		user.setLastName(adminRequest.getLastName());
		user.setRoleId(adminRequest.getRoleId());
		User savedUser = adminDao.save(user);
		String emailId = savedUser.getId() + Constants.emailprefix + Constants.emailsuffix;
		String password = "password";
		AdminReponse resp = new AdminReponse();
		return resp;
	}

}
