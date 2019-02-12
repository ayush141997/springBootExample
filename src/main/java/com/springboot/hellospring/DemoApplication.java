package com.springboot.hellospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		logger.info("This is a info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
		try {
			SpringApplication.run(DemoApplication.class, args);	
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}

