package com.prj.cas.service;

import com.prj.cas.pojo.request.AdminRequest;
import com.prj.cas.pojo.response.AdminReponse;

public interface AdminService {
	AdminReponse createUser(AdminRequest adminRequest);
}
