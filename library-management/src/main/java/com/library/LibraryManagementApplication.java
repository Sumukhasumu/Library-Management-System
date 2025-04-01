package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the entry point for the Library Management System Spring Boot
 * application. The class is annotated with @SpringBootApplication, which
 * enables Spring Boot's auto-configuration and component scanning features.
 */
@SpringBootApplication
public class LibraryManagementApplication {

	/**
	 * The main method serves as the starting point of the application. It uses
	 * SpringApplication.run() to bootstrap the application, start the Spring
	 * context, and launch the embedded web server.
	 * 
	 * @param args Command-line arguments passed during the application startup.
	 */
	public static void main(String[] args) {
		// Run the Spring Boot application
		SpringApplication.run(LibraryManagementApplication.class, args);
	}
}
