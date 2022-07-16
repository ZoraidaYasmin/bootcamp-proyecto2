package com.project2.springboot.user.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigurationApp {
	
	@Value("${config.products.endpoint}")
	String url;
	
	@Bean
	@LoadBalanced
	public WebClient.Builder registerWebClient() {
		return WebClient.builder().baseUrl(url);
	}
}
