package com.faisal.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebTutorialApplication {

	public static void main(String[] args) {
		System.out.println("Hello this is my project");
		SpringApplication.run(SpringBootWebTutorialApplication.class, args);
	}

}
