package com.kosehalil.testfixApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.kosehalil")
@EntityScan(basePackages = "com.kosehalil")
@SpringBootApplication
public class TestfixApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestfixApplication.class, args);
	}

}
