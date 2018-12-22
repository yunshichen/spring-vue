package org.diego.springvue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("org.diego.springvue")
public class SpringVueApplication implements CommandLineRunner{

	@Autowired
	MyAppConfig config;

    @Override
    public void run(String... args) throws Exception {

//		System.out.println("=================== 产品环境");
//		System.out.println("=================== tomcat port: " + config.getAppPort());
//		System.out.println("=================== vue domain: " + config.getVueDomain());
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringVueApplication.class, args);
	}
}
