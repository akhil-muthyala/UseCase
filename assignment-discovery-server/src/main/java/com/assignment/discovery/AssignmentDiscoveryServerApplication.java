package com.assignment.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AssignmentDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentDiscoveryServerApplication.class, args);
	}

}
