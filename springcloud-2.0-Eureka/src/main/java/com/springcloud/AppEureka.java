package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AppEureka {
		
	//@EnableEurekaServer表示开启EurekaServer服务，开启注册中心
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SpringApplication.run(AppEureka.class, args);
		}
}
