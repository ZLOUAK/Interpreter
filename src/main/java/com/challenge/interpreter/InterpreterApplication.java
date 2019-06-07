package com.challenge.interpreter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.challenge.interpreter"})
public class InterpreterApplication {

	public static void main(String[] args) {

		SpringApplication.run(InterpreterApplication.class, args);
	}

}
