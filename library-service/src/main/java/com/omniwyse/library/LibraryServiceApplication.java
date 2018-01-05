package com.omniwyse.library;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author aashish.kumar
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
public class LibraryServiceApplication {
	private static final Logger logger = Logger.getLogger(LibraryServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
		logger.info("Library Application Started...");
	}
}
