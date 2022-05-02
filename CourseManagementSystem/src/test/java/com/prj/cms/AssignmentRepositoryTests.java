package com.prj.cms;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.prj.cms.entity.Assignment;

@DataJpaTest
public class AssignmentRepositoryTests {

	@Autowired
	private Assignment assignment;
	
	@BeforeEach
	public void setup() {
//		assignment = Assignment.
	}
	
}
