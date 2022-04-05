package com.prj.cas.service;

import com.prj.cas.pojo.request.ProfRequest;
import com.prj.cas.pojo.response.ProfReponse;

public interface ProfService {
	
	ProfReponse createCourse(ProfRequest profRequest);

}
