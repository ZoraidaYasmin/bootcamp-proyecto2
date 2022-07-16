package com.project2.springboot.user.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootWebfluxUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxUserApplication.class, args);
	}

}
