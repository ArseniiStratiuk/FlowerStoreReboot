package com.web.lab7;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab7ApplicationTests extends PostgresContainerTest {

	@Test
	void contextLoads() {
		// verifies the Spring Boot application context starts with the test container datasource
	}
}
