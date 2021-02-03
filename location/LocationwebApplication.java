package com.villain.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationwebApplication {

	public static void main(String[] args) {
		//System.setProperty("context-path","/location");
		SpringApplication.run(LocationwebApplication.class, args);
	}

}
