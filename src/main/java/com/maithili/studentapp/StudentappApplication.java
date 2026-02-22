package com.maithili.studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.maithili.studentapp")
public class StudentappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentappApplication.class, args);
	}

}
