/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.agile.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
/**
 * Entry class of the project
 * @author manjirilakhote
 *
 */
@SpringBootApplication
@EnableReactiveMongoRepositories
@ComponentScan(basePackages = "com.agile.board")
@EnableReactiveMongoAuditing
public class Application {
   
	public String healthCheck() {
		return "Health Ok";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}