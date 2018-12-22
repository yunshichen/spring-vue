package org.diego.springvue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTests {

	@Autowired
	MyAppConfig config;

	@Test
	public void test() {

		System.out.println("=================== tomcat port: " + config.getAppPort());
		System.out.println("=================== vue domain: " + config.getVueDomain());
	}

}
