package com.springcloud.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@EnableEurekaClient

@SpringBootApplication
@PropertySource("classpath:hanlp.properties")
public class AppDependencyParse {
	public static void main(String[] args) {
		SpringApplication.run(AppDependencyParse.class, args);
	}
}
