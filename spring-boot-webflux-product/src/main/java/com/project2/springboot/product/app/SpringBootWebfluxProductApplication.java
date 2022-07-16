package com.project2.springboot.product.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootWebfluxProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxProductApplication.class, args);
	}

}
