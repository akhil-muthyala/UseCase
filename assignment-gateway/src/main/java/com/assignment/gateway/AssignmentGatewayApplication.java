package com.assignment.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = "com.assignment.*")
public class AssignmentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentGatewayApplication.class, args);
	}

}
